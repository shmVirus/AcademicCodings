import java.io.*;
import java.net.*;
import java.util.Scanner;

public class dClient {
  public static void main(String[] args) throws IOException {
    Socket clientCommunication = new Socket("localhost", 2570);

    DataOutputStream output = new DataOutputStream(clientCommunication.getOutputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner =  new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    String operator = scanner.next();
    output.writeUTF(Integer.toString(a));
    output.writeUTF(Integer.toString(b));
    output.writeUTF(operator);

    DataInputStream input = new DataInputStream(clientCommunication.getInputStream());
    String string = input.readUTF();
    
    System.out.println("Answer from server: " + string);

    input.close();
    reader.close();
    output.close();
    clientCommunication.close();
  }
}