import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String q[]) throws IOException {
        Socket sc = new Socket("localhost", 8001);
        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        
        // Taking input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        // Sending numbers to the server
        out.writeUTF(String.valueOf(num1));
        out.writeUTF(String.valueOf(num2));
        out.writeUTF(String.valueOf(num3));
        
        DataInputStream in = new DataInputStream(sc.getInputStream());
        String msg = in.readUTF();
        System.out.println("Server response: " + msg);
        
        scanner.close();
    }
}
