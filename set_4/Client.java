import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String q[]) throws IOException {
        Socket sc = new Socket("localhost", 8001);
        DataOutputStream out = new DataOutputStream(sc.getOutputStream());
        
        // Taking input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter operation (+, -, *, /): ");
        String operation = scanner.next();
        System.out.print("Enter first operand: ");
        double operand1 = scanner.nextDouble();
        System.out.print("Enter second operand: ");
        double operand2 = scanner.nextDouble();

        // Sending operation and operands separated by space
        out.writeUTF(operation + " " + operand1 + " " + operand2);
        
        DataInputStream in = new DataInputStream(sc.getInputStream());
        String msg = in.readUTF();
        System.out.println("Server response: " + msg);
        
        scanner.close();
    }
}