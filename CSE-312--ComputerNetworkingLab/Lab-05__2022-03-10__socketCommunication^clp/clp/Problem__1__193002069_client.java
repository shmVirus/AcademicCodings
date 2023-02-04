import java.io.*;
import java.net.*;

public class Problem__1__193002069_client {
  public static void main(String[] args) throws IOException {
    // Creating communication port for client using Socket class
    Socket clientCommunication = new Socket("localhost", 2575);

    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");
    
    DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
    String string = "";
    // reading the input given by server
    string = input.readUTF();
    System.out.println("\033[36;1mServer Says (in LowerCase): \033[0m" + "\033[3;5m" + string.toLowerCase() + "\033[0m");

    // closing for resource utilization
    input.close();
    // ending connection to server
    clientCommunication.close();
  }
}