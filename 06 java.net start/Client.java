import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ma on 29.10.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT = 1234;
        final String HOST = "10.17.13.31";
        Socket s = new Socket(HOST, PORT);

        PrintWriter os = new PrintWriter(
                s.getOutputStream(), true);
        BufferedReader is = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()
                )
        );
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String x = is.readLine();
            System.out.println("SERVER: " + x);
            System.out.print("CLIENT: ");
            x = scanner.nextLine();
            os.println(x);
        }
    }
}
