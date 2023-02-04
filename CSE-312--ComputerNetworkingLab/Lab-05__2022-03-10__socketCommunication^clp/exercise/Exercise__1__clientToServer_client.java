import java.io.*;
import java.net.*;

public class Exercise__1__clientToServer_client {
  public static void main(String[] args) throws IOException {
    Socket clientCommunication = new Socket("localhost", 2575);

    System.out.println("\033[36;1mServer's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getPort() + "\033[0m");
    System.out.println("\033[32;1mClient's Communication Port: \033[0m" + "\033[3m" + clientCommunication.getLocalPort() + "\033[0m");

    DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string = "";
    System.out.print("\033[36;1mMessages to Server: \033[0m");
    string = reader.readLine();
    output.writeUTF(string);

    reader.close();
    output.close();
    clientCommunication.close();
  }
}