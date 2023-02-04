import java.io.*;
import java.net.*;

public class Problem__2__193002069_server {
  public static void main(String[] args) throws IOException {
    // ServerSocket class is Needed for creating handshaking port
    ServerSocket serverHandshake = new ServerSocket(2575);
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m" + "\033[3m" + serverHandshake.getLocalPort() + "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m" + "\033[32;1mWaiting for Clients...\033[0m");

    // Accepting client's TCP handshake and creating communication port for server using Socket class
    Socket serverCommunication = serverHandshake.accept();
    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + serverCommunication.getLocalPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + serverCommunication.getPort() + "\033[0m");
    
    // Using this classes to read messages from client
    DataInputStream input = new DataInputStream(serverCommunication.getInputStream());
    String string = input.readUTF();
    // converting the string to integer for the loop
    int number = Integer.parseInt(string);
    
    while (number-- != 0) { // executing and then decrementing and lastly checking the condition
      string = input.readUTF();
      System.out.println("\033[32;1mClient Says: \033[0m" + "\033[3;5m" + string + "\033[0m");
    }

    input.close();
    serverCommunication.close();
    serverHandshake.close();
  }
}