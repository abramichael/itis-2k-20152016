import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by ma on 24.11.2015.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(3456));
        ServerSocket ss = ssc.socket();
        Socket s = ss.accept();
        ByteBuffer bb = ByteBuffer.allocate(1);
        SocketChannel sc = s.getChannel();
        sc.read(bb);
        bb.flip();
        System.out.println(bb.get());
    }
}
