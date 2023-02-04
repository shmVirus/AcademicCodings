import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Exercise__1__multiClientToServer_server {
  public static void main(String args[]) throws IOException {
    ServerSocket serverHandshake = new ServerSocket(2575);
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m" + "\033[3m" + serverHandshake.getLocalPort() + "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m" + "\033[32;1mWaiting for Clients...\033[0m");
    // loop for multiple clients
    while (true) {
      Socket serverCommunication = serverHandshake.accept();
      System.out.println("\n\033[32;1mNew Client Connected to the Server!\033[0m" + "\033[32;1m");
      System.out.println("\033[36;1mAssigning Thread for \033[0m" + "\033[36;1m" + serverCommunication + "...\033[0m");
      DataOutputStream output = new DataOutputStream(serverCommunication.getOutputStream());
      DataInputStream input = new DataInputStream(serverCommunication.getInputStream());
      Thread newTunnel = new Exercise__1__multiClientToServer_clientHandler(serverCommunication, input, output);
      newTunnel.start();
    }
  }
}

class Exercise__1__multiClientToServer_clientHandler extends Thread {
  DateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
  DateFormat forTime = new SimpleDateFormat("hh:mm:ss");
  final Socket communicationTunnel;
  // for input-output
  final DataInputStream inputTunnel;
  final DataOutputStream outputTunnel;
  String received = "";
  String toReturn = "";

  // assigning objects for particular clients
  public Exercise__1__multiClientToServer_clientHandler(Socket serverCommunication, DataInputStream input,
      DataOutputStream output) {
    this.communicationTunnel = serverCommunication;
    this.inputTunnel = input;
    this.outputTunnel = output;
  }
  // for communication with client
  public void run() {
    while (true) {
      try {
        outputTunnel.writeUTF("\n\033[35;1mWhat do You Want?\033[0m \033[38;1;3;5m[date | time | exit] \033[0m\033[35;1m: \033[0m");
        received = inputTunnel.readUTF();
        if (received.equals("exit")) {
          System.out.println("\n\033[32;1mClient requested for Closing the Connection!\033[0m");
          this.communicationTunnel.close();
          System.out.println("\033[36;1mConnection closed with " + this.communicationTunnel + "...\033[0m");
          break;
        }

        Date date = new Date();
        switch (received) {
          case "date":
            toReturn = "\033[33;1mDate: \033[0m" + "\033[5;3m" + forDate.format(date) + "\033[0m";
            outputTunnel.writeUTF(toReturn);
            break;
          case "time":
            toReturn = "\033[33;1mTime: \033[0m" + "\033[5;3m" + forTime.format(date) + "\033[0m";
            outputTunnel.writeUTF(toReturn);
            break;
          default:
            toReturn = "\033[31;1;5mInvalid Input!, Try again...\033[0m";
            outputTunnel.writeUTF(toReturn);
        }
      } catch (IOException exception) {
        //System.out.println(exception);
      }
    }

    try {
      this.outputTunnel.close();
      this.inputTunnel.close();
    } catch (IOException exception) {
      //System.out.println(exception);
    }
  }
}