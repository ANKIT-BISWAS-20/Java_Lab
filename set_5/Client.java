import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String q[]) throws IOException {
        Socket sc = new Socket("localhost", 8001);
        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        
        // Taking input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate factorial: ");
        int number = scanner.nextInt();

        // Sending number to the server
        out.writeUTF(String.valueOf(number));
        
        DataInputStream in = new DataInputStream(sc.getInputStream());
        String msg = in.readUTF();
        System.out.println(msg);
        
        scanner.close();
    }
}
