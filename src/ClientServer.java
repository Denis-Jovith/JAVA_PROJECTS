import java.io.*;
import java.net.*;

public class ClientServer {

    static class Server extends Thread {
        public void run() {
            try {
                ServerSocket serverSocket = new ServerSocket(1234);
                System.out.println("Server waiting for connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientMessage = input.readLine();
                System.out.println("Message from client: " + clientMessage);

                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        Thread serverThread = new Server();
        serverThread.start();

        try {
            Thread.sleep(1000);

            Socket socket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from the client!");
            socket.close();
        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}
