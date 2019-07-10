package my.pvt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            do {
                Socket socket = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream());

                dos.writeUTF("HELLO WORLD");
                dos.flush();

                String input = "";
                do {
                    input = dis.readUTF();
                    System.out.println("CLIENT: " + input);
                } while (!"END".equals(input));

                dos.close();
                dis.close();
                socket.close();

                String cmd = "";
                if (cmd.equals("EXIT")) break;
            } while (true);
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
