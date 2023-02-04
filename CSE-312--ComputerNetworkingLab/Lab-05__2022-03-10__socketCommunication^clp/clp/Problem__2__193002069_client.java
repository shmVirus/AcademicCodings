import java.io.*;
import java.net.*;
import java.util.*;

public class Problem__2__193002069_client {
  public static void main(String[] args) throws IOException {
    // Creating communication port for client using Socket class
    Socket clientCommunication = new Socket("localhost", 2575);

    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");

    DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    Scanner scanner = new Scanner(System.in);
    System.out.print("\033[36;1mNumber of Messages to Server: \033[0m");
    // taking n number, to send n messsages to server
    int number = scanner.nextInt();
    // converting to string
    String string = Integer.toString(number);
    // sending to server to close server properly after last message
    output.writeUTF(string);

    while (number-- != 0) { // executing and then decrementing and lastly checking the condition
      System.out.print("\033[36;1mMessages to Server: \033[0m");
      string = reader.readLine();
      output.writeUTF(string);
    }
    
    scanner.close();
    reader.close();
    output.close();
    clientCommunication.close();
  }
}