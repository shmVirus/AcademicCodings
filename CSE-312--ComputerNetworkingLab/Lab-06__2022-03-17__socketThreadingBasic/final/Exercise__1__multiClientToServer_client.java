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

      DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
      Scanner scanner = new Scanner(System.in);

      while (true) {
        String inLine = input.readUTF();
        System.out.print(inLine);
        String outLine = scanner.nextLine();
        output.writeUTF(outLine);
        if (outLine.equals("exit")) {
          clientCommunication.close();
          System.out.println("\n\033[32;1mConnection closed with " + clientCommunication + "\033[0m");
          break;
        }
        String received = input.readUTF();
        System.out.println(received);
      }
      scanner.close();
      input.close();
      reader.close();
      output.close();
      clientCommunication.close();
    } catch (Exception exception) {
      //System.out.println(exception);
    }
  }
}