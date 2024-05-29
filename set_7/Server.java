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
            int num1 = Integer.parseInt(in.readUTF());
            int num2 = Integer.parseInt(in.readUTF());
            int num3 = Integer.parseInt(in.readUTF());

            System.out.println("Client sent: " + num1 + ", " + num2 + ", " + num3);

            int smallest = Math.min(num1, Math.min(num2, num3));
            
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF("Smallest number is: " + smallest + "\n");
        }
    }
}
