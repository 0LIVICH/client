import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))) {

            out.println("Client");

            String response = in.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}