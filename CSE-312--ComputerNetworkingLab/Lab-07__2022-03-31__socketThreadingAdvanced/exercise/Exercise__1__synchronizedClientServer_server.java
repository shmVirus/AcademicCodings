import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Exercise__1__synchronizedClientServer_server {
  public static void main(String[] args) throws IOException {
    ServerSocket serverHandshake = new ServerSocket(2575);
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m" + "\033[3m" + serverHandshake.getLocalPort() + "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m" + "\033[32;1mWaiting for Clients...\033[0m");

    Socket serverCommunication = serverHandshake.accept();
    Thread threadSend = new ServerSend(serverCommunication);
    threadSend.start();
    Thread threadReceive = new ServerReceive(serverCommunication);
    threadReceive.start();
  }
}

class ServerReceive extends Thread {
  private Socket serverCommunication;
  public ServerReceive(Socket serverCommunication) {
    this.serverCommunication = serverCommunication;
  }

  @Override
  public void run() {
    while (true) {
      try {
        DataInputStream input = new DataInputStream(serverCommunication.getInputStream());
        String stringInput = input.readUTF();
        System.out.println("\033[32;1mClient Says: \033[0m" + "\033[3;5m" + stringInput + "\033[0m");
      } catch (IOException exception) {
        // Logger.getLogger(ServerReceive.class.getName()).log(Level.SEVERE, null, exception);
      }
    }
  }
}

class ServerSend extends Thread {
  private Socket serverCommunication;
  public ServerSend(Socket serverCommunication) {
    this.serverCommunication = serverCommunication;
  }

  @Override
  public void run() {
    while (true) {
      try {
        DataOutputStream output = new DataOutputStream(serverCommunication.getOutputStream());
        String stringOutput;
        Scanner scanner = new Scanner(System.in);
        stringOutput = scanner.nextLine();
        output.writeUTF(stringOutput);
      } catch (IOException exception) {
        // Logger.getLogger(ServerSend.class.getName()).log(Level.SEVERE, null, exception);
      }
    }
  }
}