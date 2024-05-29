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
            String str = in.readUTF();
            System.out.println("Message From Client: " + str);

            String response = isPalindrome(str) ? "YES" : "NO";
            
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            out.writeUTF(response + "\n");
        }
    }
    
    // Method to check if a string is palindrome or not
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
