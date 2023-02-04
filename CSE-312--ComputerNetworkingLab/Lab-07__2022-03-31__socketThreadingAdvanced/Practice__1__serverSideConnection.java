/* Server Side Code */
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

public class Practice__1__serverSideConnection {
  public static void main(String[] args) throws IOException {
    ServerSocket handshake = new ServerSocket(5555);
    System.out.println("Server is connected at port no: " +
                       handshake.getLocalPort());
    Socket skt = handshake.accept();
    Thread thread1 = new server_send(skt);
    thread1.start();
    Thread thread2 = new server_receive(skt);
    thread2.start();
  }
}

class server_receive extends Thread {
  private Socket skt;
  public server_receive(Socket skt) { this.skt = skt; }
  @Override
  public void run() {
    while (true) {
      try {
        DataInputStream in = new DataInputStream(skt.getInputStream());
        String string = in.readUTF();
        System.out.println("Client Says: " + string);
      } catch (IOException ex) {
        Logger.getLogger(server_receive.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}

class server_send extends Thread {
  private Socket skt;
  public server_send(Socket skt) { this.skt = skt; }

  @Override
  public void run() {
    while (true) {
      try {
        DataOutputStream out = new DataOutputStream(skt.getOutputStream());
        String str;
        Scanner scn = new Scanner(System.in);
        str = scn.nextLine();
        out.writeUTF(str);
      } catch (IOException ex) {
        Logger.getLogger(server_send.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}