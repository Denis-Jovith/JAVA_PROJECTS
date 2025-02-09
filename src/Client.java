import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from the client!");
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
