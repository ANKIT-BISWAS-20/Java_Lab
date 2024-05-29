package set_1;
import java.io.*;
import java.net.*;

public class ServerEx1 {
    public static void main(String q[]) throws IOException {
        System.out.println("Hello welcome....");
        ServerSocket ss = new ServerSocket(8001); // listening
        System.out.println("\nServer Running.....");
        while (true) {
            System.out.println("Server wait for Client Request...");
            Socket cs = ss.accept(); // binding
            DataInputStream in = new DataInputStream(cs.getInputStream());
            String msg = in.readUTF();
            System.out.println("Message From Client: " + msg);
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF("HI I am Server.." + "\n");
        }
    }
}
