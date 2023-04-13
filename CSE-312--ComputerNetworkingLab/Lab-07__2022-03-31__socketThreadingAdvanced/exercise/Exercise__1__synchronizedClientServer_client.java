import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Exercise__1__synchronizedClientServer_client {
  public static void main(String[] args) throws IOException {
    Socket clientCommunication = new Socket("localhost", 2575);
    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");

    
    Thread threadSend = new clientSend(clientCommunication);
    threadSend.start();
    Thread threadReceive = new clientReceive(clientCommunication);
    threadReceive.start();
  }
}

class clientReceive extends Thread {
  private Socket clientCommunication;
  public clientReceive(Socket clientCommunication) {
    this.clientCommunication = clientCommunication;
  }

  @Override
  public void run() {
    while (true) {
      try {
        DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
        String stringInput = input.readUTF();
        System.out.println("\033[36;1mServer Says: \033[0m" + "\033[3;5m" + stringInput + "\033[0m");
      } catch (IOException exception) {
        // Logger.getLogger(clientReceive.class.getName()).log(Level.SEVERE, null, exception);
      }
    }
  }
}

class clientSend extends Thread {
  private Socket clientCommunication;
  public clientSend(Socket clientCommunication) {
    this.clientCommunication = clientCommunication;
  }

  @Override
  public void run() {
    while (true) {
      try {
        DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
        String stringOutput;
        Scanner scanner = new Scanner(System.in);
        stringOutput = scanner.nextLine();
        output.writeUTF(stringOutput);
      } catch (IOException exception) {
        // Logger.getLogger(clientSend.class.getName()).log(Level.SEVERE, null, exception);
      }
    }
  }
}