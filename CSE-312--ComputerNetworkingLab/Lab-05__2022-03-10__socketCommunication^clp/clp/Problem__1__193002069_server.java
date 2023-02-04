import java.io.*;
import java.net.*;

public class Problem__1__193002069_server {
  public static void main(String[] args) throws IOException {
    // ServerSocket class is Needed for creating handshaking port
    ServerSocket serverHandshake = new ServerSocket(2575);
    // Using ASCII escape sequence characters for formatting
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m" + "\033[3m" + serverHandshake.getLocalPort() + "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m" + "\033[32;1mWaiting for Clients...\033[0m");

    // Accepting client's TCP handshake and creating communication port for server using Socket class
    Socket serverCommunication = serverHandshake.accept();
    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + serverCommunication.getLocalPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + serverCommunication.getPort() + "\033[0m");

    // Using these classes to send messages to client
    DataOutputStream output = new DataOutputStream(serverCommunication.getOutputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string = "";
    System.out.print("\033[32;1mMessages to Client: \033[0m");
    string = reader.readLine();
    // pushing the string to client side
    output.writeUTF(string);
    
    // closing for resource utilization
    reader.close();
    output.close();
    // ending connection to client and closing handshake port
    serverCommunication.close();
    serverHandshake.close();
  }
}