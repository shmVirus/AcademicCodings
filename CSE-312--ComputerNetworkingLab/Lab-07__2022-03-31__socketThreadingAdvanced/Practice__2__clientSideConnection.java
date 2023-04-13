/* Client Side Code */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Practice__2__clientSideConnection {
  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("Localhost", 5555);
    System.out.println("Connected at server’s handshaking port no: " +
                       socket.getPort());
    System.out.println("Client’s is connecting at communication port " +
                       socket.getLocalPort());
    System.out.println("Client is Connected");
    Thread thread1 = new client_send(socket);
    thread1.start();

    Thread thread2 = new client_receive(socket);
    thread2.start();
  }
}

class client_receive extends Thread {
  private Socket skt;
  public client_receive(Socket skt) { this.skt = skt; }
  @Override
  public void run() {
    while (true) {
      try {
        DataInputStream in = new DataInputStream(skt.getInputStream());
        String string = in.readUTF();

        System.out.println("Server Says: " + string);
      } catch (IOException ex) {
        Logger.getLogger(server_receive.class.getName())
            .log(Level.SEVERE, null, ex);
      }
    }
  }
}

class client_send extends Thread {
  private Socket skt;
  public client_send(Socket skt) { this.skt = skt; }

  @Override
  public void run() {
    while (true) {
      try {
        DataOutputStream out = new DataOutputStream(skt.getOutputStream());
        String str;
        Scanner scn = new Scanner(System.in);
        str = scn.nextLine();
        out.writeUTF(str);
      } catch (IOException ex) {
        Logger.getLogger(server_send.class.getName())
            .log(Level.SEVERE, null, ex);
      }
    }
  }
}