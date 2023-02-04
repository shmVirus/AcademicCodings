
/** @author: shmVirus*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe implements Runnable { // Runnable class for executing run method, run is abstract in Runnable
    // private to keep everything inside TicTacToe class; starting with less visibility is good practice, when needed we can make visible
    private String ip = "localhost";
    private int port = 2575;
    private Scanner scanner = new Scanner(System.in);
    private JFrame frame;       // inherits Frame class, used for main window
    private final int WIDTH = 506;
    private final int HEIGHT = 527;
    private Thread thread;

    private Painter painter;        // not default, implemented custom constructor for painting gui
    private ServerSocket handshake; // to accept opponent's join request
    private Socket socket;          // for communicating between players
    private DataOutputStream output;
    private DataInputStream input;

    // BufferedImage is a subclass of Image class; used here to load images
    private BufferedImage board;
    private BufferedImage redX;
    private BufferedImage blueX;
    private BufferedImage redO;
    private BufferedImage blueO;

    private String[] gridBoard = new String[9]; // since 9 squares in tic-tac-toe board

    private boolean turnHost = false;       // player who hosted the game
    private boolean turnOpponent = true;    // player who joined the game
    private boolean accepted = false;
    private boolean unableToCommunicateWithOpponent = false;
    private boolean wonHost = false;
    private boolean wonOpponent = false;
    private boolean tie = false;

    private int lengthOfSpace = 160;    // each small square's size
    private int errors = 0;             // to check and control connecting issues
    private int firstSpot = -1;         // works like placeholder; used to draw the wining line on the window 
    private int secondSpot = -1;

    // Font class, to use custom font(s) on the window
    private Font font = new Font("FontAwesome", Font.BOLD, 30);
    private Font smallerFont = new Font("FontAwesome", Font.BOLD, 20);
    private Font largerFont = new Font("FontAwesome", Font.BOLD, 50);

    // different strings to place on window for different stages of the game
    private String waitingString = "Waiting for Opponent...";
    private String unableToCommunicateWithOpponentString = "Unable to Communicate with Opponent...";
    private String wonStringPlayer = "You Won!";
    private String wonStringOpponent = "Opponent Won!";
    private String tieString = "Game ended in a Tie";

    // combinations of wining spaces on 3x3 grid board
    private int[][] wins = new int[][] {    { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
                                            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                                            { 0, 4, 8 }, { 2, 4, 6 } };

    public TicTacToe() {
        System.out.print("IP: ");
        ip = scanner.nextLine();        // not validating IP, since there's a lot to check it about
        System.out.print("Port: ");
        do {
            port = scanner.nextInt();
            if (port >= 0 && port <= 1023) {
                System.out.print("Reserved Port, try with different Port: ");
            } else if (port < 1024 || port > 65535) {
                System.out.print("Invalid Port, try with different Port: ");
            }
        } while (port < 1024 || port > 65535 );

        loadImages();       // invoking to load our custom images

        painter = new Painter();
        painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        if (!connect()) {
            initializeServer();     // if no one waiting at that IP and port, then the game hosted by this player
        }

        // setting up the GUI window with different properties
        frame = new JFrame();
        frame.setTitle("TicTacToe");
        frame.setContentPane(painter);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        thread = new Thread(this, "TicTacToe");
        thread.start();     // starting the run method
    }

    public void run() {
        while (true) {
            tick();
            painter.repaint();

            if (!turnOpponent && !accepted) {
                listenForServerRequest();       // host player is  waiting for opponent player to join the game
            }
        }
    }

    private void checkForWin() {
        for (int i = 0; i < wins.length; i++) {
            if (turnOpponent) {
                if (gridBoard[wins[i][0]] == "O" && gridBoard[wins[i][1]] == "O" && gridBoard[wins[i][2]] == "O") {
                    firstSpot = wins[i][0];
                    secondSpot = wins[i][2];
                    wonHost = true;
                }
            } else {
                if (gridBoard[wins[i][0]] == "X" && gridBoard[wins[i][1]] == "X" && gridBoard[wins[i][2]] == "X") {
                    firstSpot = wins[i][0];
                    secondSpot = wins[i][2];
                    wonHost = true;
                }
            }
        }
    }

    private void checkForEnemyWin() {
        for (int i = 0; i < wins.length; i++) {
            if (turnOpponent) {
                if (gridBoard[wins[i][0]] == "X" && gridBoard[wins[i][1]] == "X" && gridBoard[wins[i][2]] == "X") {
                    firstSpot = wins[i][0];
                    secondSpot = wins[i][2];
                    wonOpponent = true;
                }
            } else {
                if (gridBoard[wins[i][0]] == "O" && gridBoard[wins[i][1]] == "O" && gridBoard[wins[i][2]] == "O") {
                    firstSpot = wins[i][0];
                    secondSpot = wins[i][2];
                    wonOpponent = true;
                }
            }
        }
    }

    private void checkForTie() {
        for (int i = 0; i < gridBoard.length; i++) {
            if (gridBoard[i] == null) {
                if (i+1 == gridBoard.length) {  // checking the last move for player X
                    gridBoard[i]="X";
                    checkForWin();
                    checkForEnemyWin();
                    return;
                }
                return;
            }
        }
        tie = true;
    }

    private void tick() {
        if (errors >= 10) {
            unableToCommunicateWithOpponent = true;
        }

        if (!turnHost && !unableToCommunicateWithOpponent) {
            try {
                // these writes the opponent moves on player side, to (easily) understand, red ones on the window
                int position = input.readInt();
                if (turnOpponent) {
                    gridBoard[position] = "X";  // move given by joined player's opponent, painting on joined player's side
                } else {
                    gridBoard[position] = "O";  // move given by host player's opponent, painting on host player's side
                }
                checkForEnemyWin();             // after moves, checking if opponent won the game or not
                checkForTie();                  
                turnHost = true;
            } catch (IOException exception) {
                exception.printStackTrace();
                errors++;
            }
        }
    }

    private void listenForServerRequest() {
        Socket socket = null;
        try {
            socket = handshake.accept();        // accepting opponent player's join request
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("Opponent has requested to play, request Accepted!");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void initializeServer() {
        try {
            handshake = new ServerSocket(port, 8, InetAddress.getByName(ip));   // to bind IP and port, we need this constructor with 3 parameters: port, backlog, IP
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        turnHost = true;        // as request is accepted, host player becomes first (X) player
        turnOpponent = false;   // as request is accepted, joined player becomes second (O) player
    }

    private boolean connect() {
        try {
            socket = new Socket(ip, port);  // requesting to join with player at this IP and port
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            accepted = true;
        } catch (IOException exception) {
            System.out.println("Unable to connect with Opponent: " + ip + ":" + port + " | Hosting the Game");
            return false;
        }
    
        System.out.println("Connected with Opponent!");
        return true;
    }

    @SuppressWarnings("unused")     //ignores warnings related to unused code
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }

    private void loadImages() {
        try {
            // 500x500 board, each square 160x160, each lines of 12px width
            board = ImageIO.read(getClass().getResourceAsStream("/board.png"));
            // 160x160, 10px border between edges
            redX = ImageIO.read(getClass().getResourceAsStream("/redX.png"));
            redO = ImageIO.read(getClass().getResourceAsStream("/redO.png"));
            blueX = ImageIO.read(getClass().getResourceAsStream("/blueX.png"));
            blueO = ImageIO.read(getClass().getResourceAsStream("/blueO.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void render(Graphics graphics) {    // this method renders all graphics for different states like waiting, playing, after end
        // in this method, different formula's has been applied to print the string in middle 
        // WIDTH/2 - stringWidth helps to print the string in middle of width and HEIGHT/2 for printing in middle of height
        graphics.drawImage(board, 0, 0, null);
        if (unableToCommunicateWithOpponent) {  // this renders graphics, when unable to connect (not while waiting) with opponent
            graphics.setColor(Color.MAGENTA);
            graphics.setFont(smallerFont);
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int stringWidth = graphics2D.getFontMetrics().stringWidth(unableToCommunicateWithOpponentString);
            graphics.drawString(unableToCommunicateWithOpponentString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
            return;
        }

        if (accepted) {
            for (int i = 0; i < gridBoard.length; i++) {    // this renders graphics while players playing the game
                if (gridBoard[i] != null) {
                    if (gridBoard[i].equals("X")) {
                        if (turnOpponent) {
                            graphics.drawImage(redX, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
                        } else {
                            graphics.drawImage(blueX, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
                        }
                    } else if (gridBoard[i].equals("O")) {
                        if (turnOpponent) {
                            graphics.drawImage(blueO, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
                        } else {
                            graphics.drawImage(redO, (i % 3) * lengthOfSpace + 10 * (i % 3), (int) (i / 3) * lengthOfSpace + 10 * (int) (i / 3), null);
                        }
                    }
                }
            }

            if (wonHost || wonOpponent) {       // this renders graphics when a players wins/looses
                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics2D.setStroke(new BasicStroke(10));
                graphics.setColor(Color.BLACK);
                graphics.drawLine(firstSpot % 3 * lengthOfSpace + 10 * firstSpot % 3 + lengthOfSpace / 2, (int) (firstSpot / 3) * lengthOfSpace + 10 * (int) (firstSpot / 3) + lengthOfSpace / 2, secondSpot % 3 * lengthOfSpace + 10 * secondSpot % 3 + lengthOfSpace / 2, (int) (secondSpot / 3) * lengthOfSpace + 10 * (int) (secondSpot / 3) + lengthOfSpace / 2);
                graphics.setFont(largerFont);
                if (wonHost) {
                    graphics.setColor(Color.BLUE);
                    int stringWidth = graphics2D.getFontMetrics().stringWidth(wonStringPlayer);
                    graphics.drawString(wonStringPlayer, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
                } else if (wonOpponent) {
                    graphics.setColor(Color.RED);
                    int stringWidth = graphics2D.getFontMetrics().stringWidth(wonStringOpponent);
                    graphics.drawString(wonStringOpponent, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
                }
            }

            if (tie) {     // this renders graphics when game ends with tie
                Graphics2D graphics2D = (Graphics2D) graphics;
                graphics.setColor(Color.BLACK);
                graphics.setFont(largerFont);
                int stringWidth = graphics2D.getFontMetrics().stringWidth(tieString);
                graphics.drawString(tieString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
            }
        } else {    // this renders graphics when a player waits for another player
            graphics.setColor(Color.MAGENTA);
            graphics.setFont(font);
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            int stringWidth = graphics2D.getFontMetrics().stringWidth(waitingString);
            graphics.drawString(waitingString, WIDTH / 2 - stringWidth / 2, HEIGHT / 2);
        }
    }

    private class Painter extends JPanel implements MouseListener { // extending to JPanel for window, implementing MouseListener for mouse events
        public Painter() {
            setFocusable(true);
            requestFocus();
            setBackground(Color.WHITE);     // setting background of the window
            addMouseListener(this);         // adding mouse listener for the window, to take marks on the grid by the players
        }

        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            render(graphics);
        }

        @Override
        public void mouseClicked(MouseEvent event) {
            if (accepted) {
                if (turnHost && !unableToCommunicateWithOpponent && !wonHost && !wonOpponent) {
                    // diving the pixel location with the width of the small square. to get index/position
                    int x = event.getX() / lengthOfSpace;
                    int y = event.getY() / lengthOfSpace;

                    y *= 3;     // multiplying to get index's value, replacing y with x won't work
                    int position = x + y;

                    // these writes the player moves on player side, to (easily) understand, blue ones on the window
                    if (gridBoard[position] == null) {
                        if (!turnOpponent) {
                            gridBoard[position] = "X";  // move given by host player, painting on host player's side
                        } else {
                            gridBoard[position] = "O"; // move given by joined player, painting on joined player's side
                        }

                        turnHost = false;
                        repaint();
                        Toolkit.getDefaultToolkit().sync();     // used for GUI window
                        try {
                            output.writeInt(position);
                            output.flush();
                        } catch (IOException exception) {
                            errors++;
                            exception.printStackTrace();
                        }

                        System.out.println("Marked on the Grid!");
                        checkForWin();
                        checkForTie();
                    }
                }
            }
        }

        // these abstract methods needed for Painter class, to avoid event related errors
        @Override
        public void mousePressed(MouseEvent event) {

        }

        @Override
        public void mouseReleased(MouseEvent event) {

        }

        @Override
        public void mouseEntered(MouseEvent event) {

        }

        @Override
        public void mouseExited(MouseEvent event) {

        }
    }
}