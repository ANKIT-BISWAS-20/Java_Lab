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
            String[] input = in.readUTF().split(" "); // Split input string by space
            double result = 0;
            switch (input[0]) {
                case "+":
                    result = Double.parseDouble(input[1]) + Double.parseDouble(input[2]);
                    break;
                case "-":
                    result = Double.parseDouble(input[1]) - Double.parseDouble(input[2]);
                    break;
                case "*":
                    result = Double.parseDouble(input[1]) * Double.parseDouble(input[2]);
                    break;
                case "/":
                    result = Double.parseDouble(input[1]) / Double.parseDouble(input[2]);
                    break;
            }
            System.out.println("Result Sent To Client : " + result);
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF("Result: " + result + "\n");
        }
    }
}
