import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT = 3456;
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("Starting server");
        Socket s = ss.accept();
        System.out.println("Connected!");

        PrintWriter os = new PrintWriter(
                s.getOutputStream(), true);
        BufferedReader is = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()
                )
        );
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("SERVER: ");
            String x = scanner.nextLine();
            os.println(x);
            x = is.readLine();
            System.out.println("CLIENT: " + x);
        }
    }
}
