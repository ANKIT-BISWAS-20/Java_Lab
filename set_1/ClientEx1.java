package set_1;
import java.io.*;
import java.net.*;

public class ClientEx1 {
    public static void main(String q[]) throws IOException {
        Socket sc = new Socket("localhost", 8001);
        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        out.writeUTF("HI I am Client.." + "\n");
        DataInputStream in = new DataInputStream(sc.getInputStream());
        String msg = in.readUTF();
        System.out.println("Message From Server: " + msg);
    }
}
