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
            int number = Integer.parseInt(in.readUTF()); // Read the number from client
            System.out.println("Number received from Client: " + number);
            
            long factorial = calculateFactorial(number);
            
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF("Factorial of " + number + " is: " + factorial + "\n");
        }
    }
    
    // Method to calculate factorial
    private static long calculateFactorial(int number) {
        if (number == 0)
            return 1;
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
