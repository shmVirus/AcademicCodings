import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Exercise__1__multiClientToServer_client {
  public static void main(String args[]) throws IOException {
    try {
      Socket clientCommunication = new Socket("localhost", 2575);
      System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
      System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");
      // for input-output
      DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
      Scanner scanner = new Scanner(System.in);
      // for communicating with server
      String inputLine = input.readUTF();
      System.out.print(inputLine);
      String outputLine = scanner.nextLine();
      output.writeUTF(outputLine);
      inputLine = input.readUTF();
      System.out.print(inputLine);
      clientCommunication.close();
      System.out.println("\n\033[32;1mConnection Closed with " + clientCommunication + "\033[0m");
      // closing objects, to prevent memory leakage
      scanner.close();
      input.close();
      reader.close();
      output.close();
    } catch (Exception exception) {
      //System.out.println(exception);
    }
  }
}