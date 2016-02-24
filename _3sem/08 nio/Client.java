import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by ma on 24.11.2015.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        /*
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress("localhost", 3456));
        ByteBuffer bb = ByteBuffer.allocate(1);
        bb.put((byte)42);
        bb.flip();
        sc.write(bb);
        */
        new Socket("localhost", 3456).getOutputStream().write(42);

    }
}
