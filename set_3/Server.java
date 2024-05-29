import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
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
            InetAddress ipobj=InetAddress.getLocalHost();
            String ip_address=ipobj.getHostAddress();
            // String host_name=ipobj.getHostName();
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF("IP Address of Server : " + ip_address +"\n");
        }
    }
}
