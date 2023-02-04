import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class Exercise__1__multiClientToServer_server {
  public static void main(String args[]) throws IOException {
    ServerSocket serverHandshake = new ServerSocket(2575);
    System.out.println("\033[36;1mServer's Handshaking Port: \033[0m"
                       + "\033[3m" + serverHandshake.getLocalPort() +
                       "\033[0m");
    System.out.println("\033[36;1mServer is UP! \033[0m"
                       + "\033[32;1mWaiting for Clients...\033[0m");
    // loop for multiple clients
    while (true) {
      Socket serverCommunication = serverHandshake.accept();
      System.out.println(
          "\n\033[32;1mNew Client Connected to the Server!\033[0m"
          + "\033[32;1m");
      System.out.println("\033[36;1mAssigning Thread for \033[0m"
                         + "\033[36;1m" + serverCommunication + "...\033[0m");
      DataOutputStream output =
          new DataOutputStream(serverCommunication.getOutputStream());
      DataInputStream input =
          new DataInputStream(serverCommunication.getInputStream());
      Thread newTunnel = new Exercise__1__multiClientToServer_clientHandler(
          serverCommunication, input, output);
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
  public Exercise__1__multiClientToServer_clientHandler(
      Socket serverCommunication, DataInputStream input,
      DataOutputStream output) {
    this.communicationTunnel = serverCommunication;
    this.inputTunnel = input;
    this.outputTunnel = output;
  }
  // for communication with client
  public void run() {
    while (true) {
      try {
        outputTunnel.writeUTF("\n\033[35;1mString: \033[0m");
        received = inputTunnel.readUTF();

        if (received.equals("exit")) {
          System.out.println(
              "\n\033[32;1mClient requested for Closing the Connection!\033[0m");
          this.communicationTunnel.close();
          System.out.println("\033[36;1mConnection closed with " +
                             this.communicationTunnel + "...\033[0m");
          break;
        }

        int[] freq = new int[received.length()];
        // Converting given string into character array
        char characters[] = received.toCharArray();
        for (int i = 0; i < received.length(); i++) {
          freq[i] = 1;
          for (int j = i + 1; j < received.length(); j++) {
            if (characters[i] == characters[j]) {
              freq[i]++;
              // Set characters[j] to 0 to avoid printing visited character
              characters[j] = '0';
            }
          }
        }

        int frequent = freq[0];
        String character = "" + characters[0];
        for (int i = 1; i < freq.length; i++) {
          if (freq[i] > frequent) {
            frequent = freq[i];
            character = "" + characters[i];
          }
        }
        String send = Integer.toString(frequent);
        //outputTunnel.writeUTF("\nCharacter: " + character + "\tCharacter: " + send);
        outputTunnel.writeUTF("\033[33;1mCharacter: \033[0m" + character + "\t\033[33;1mCharacter: \033[0m" + send);

      } catch (IOException exception) {
        // System.out.println(exception);
      }
    }

    /*try {
      this.outputTunnel.close();
      this.inputTunnel.close();
    } catch (IOException exception) {
      // System.out.println(exception);
    }*/
  }
}