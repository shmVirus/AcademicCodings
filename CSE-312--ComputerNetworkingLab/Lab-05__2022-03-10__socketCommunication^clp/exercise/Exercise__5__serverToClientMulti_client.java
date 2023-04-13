import java.io.*;
import java.net.*;

public class Exercise__5__serverToClientMulti_client {
  public static void main(String[] args) throws IOException {
    Socket clientCommunication = new Socket("localhost", 2575);

    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");
    
    DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
    String string = "";
    while (!string.equals("exit")) {
      string = input.readUTF();
      System.out.println("\033[36;1mServer Says: \033[0m" + "\033[3;5m" + string + "\033[0m");  
    }
    
    input.close();
    clientCommunication.close();
  }
}