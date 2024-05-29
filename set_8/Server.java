import java.io.*;
import java.net.*;

public class Server {
    public static void main(String q[]) throws IOException {
        System.out.println("Hello welcome....");
        ServerSocket ss = new ServerSocket(8001); // listening
        System.out.println("\nServer Running.....");
        while (true) {
            System.out.println("Server wait for Client Request...");
            Socket cs = ss.accept(); // binding
            DataInputStream in = new DataInputStream(cs.getInputStream());
            String str1 = in.readUTF();
            String str2 = in.readUTF();

            System.out.println("String 1: " + str1);
            System.out.println("String 2: " + str2);

            String response = str1.equals(str2) ? "YES" : "NO";
            
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF(response + "\n");
        }
    }
}
