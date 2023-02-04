import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Exercise__1__multiClientToServer_server {
  public static void main(String args[]) throws IOException {
    ServerSocket serverHandshake = new ServerSocket(2575);
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m" + "\033[3m" + serverHandshake.getLocalPort() + "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m" + "\033[32;1mWaiting for Clients...\033[0m");
    // loop to handle multiple clients
    int numberOfClients = 0, maximumClients = 10;
    while (++numberOfClients <= maximumClients) {
      Socket serverCommunication = serverHandshake.accept();
      System.out.println("\n\033[32;1mNew Client Connected to the Server! Remaining Slots: \033[0m" + "\033[32;1m" + (maximumClients-numberOfClients) + "\033[0m");
      System.out.println("\033[36;1mAssigning Thread for \033[0m" + "\033[36;1m" + serverCommunication + "\033[0m");
      DataOutputStream output = new DataOutputStream(serverCommunication.getOutputStream());
      DataInputStream input = new DataInputStream(serverCommunication.getInputStream());
      // assigning individual threads for each client
      Thread newTunnel = new Exercise__1__multiClientToServer_clientHandler(serverCommunication, input, output);
      // starting thread that is being created for each client
      newTunnel.start();
    }
  }
}

class Exercise__1__multiClientToServer_clientHandler extends Thread {
  final Socket communicationTunnel;
  // for input-output
  final DataInputStream inputTunnel;
  final DataOutputStream outputTunnel;
  String string = "";
  String lowerCasedString = "";
  // assigning objects for particular clients
  public Exercise__1__multiClientToServer_clientHandler(Socket serverCommunication, DataInputStream input, DataOutputStream output) {
    this.communicationTunnel = serverCommunication;
    this.inputTunnel = input;
    this.outputTunnel = output;
  }

  // application specific implementation, for communication with client
  public void run() {
    try {
      outputTunnel.writeUTF("\n\033[32;1mInput String: \033[0m");
      string = inputTunnel.readUTF();
      lowerCasedString = "\033[36;1mLowerCased String: \033[0m" + "\033[3;5m" + string.toLowerCase() + "\033[0m";
      outputTunnel.writeUTF(lowerCasedString);
      this.communicationTunnel.close();
      System.out.println("\033[36;1mConnection Closed with " + this.communicationTunnel + "\033[0m");
    } catch (IOException exception) {
      // System.out.println(exception);
    }
    try {
      this.outputTunnel.close();
      this.inputTunnel.close();
    } catch (IOException exception) {
      // System.out.println(exception);
    }
  }
}