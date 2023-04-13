import java.io.*;
import java.net.*;

public class dServer {
  public static void main(String[] args) throws IOException {
    ServerSocket serverHandshake = new ServerSocket(2570);
    Socket serverCommunication = serverHandshake.accept();
    DataInputStream input = new DataInputStream(serverCommunication.getInputStream());
    String string = "";
    string = input.readUTF();
    int a = Integer.parseInt(string);
    string = input.readUTF();
    int b = Integer.parseInt(string);
    
    String operator = input.readUTF();
    
    int res = 0;
    if ( operator.equals("+")) {
        string = "add";
        res = a + b;
    } else if ( operator.equals("-")) {
        string = "subtract";
        res = a - b;
    } else if ( operator.equals("*")) {
        string = "product";
        res = a * b;
    } else if ( operator.equals("/")) {
        string = "divide";
        res = a / b;
    }
    System.out.println("The two integers and operation from client are: " + a + "," +b + "," + string);
    
    string = Integer.toString(res);
    DataOutputStream output = new DataOutputStream(serverCommunication.getOutputStream());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    output.writeUTF(string);

    reader.close();
    output.close();
    input.close();
    serverCommunication.close();
    serverHandshake.close();
  }
}