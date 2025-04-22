import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);


            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection accepted from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            out.println("Hi " + clientMessage + ", your port is " + clientSocket.getPort());

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
