import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by ma on 24.11.2015.
 */
public class NIOStart {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("in.txt");
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(20);

        Charset cs = Charset.forName("utf-8");

        while (fc.read(bb) != -1 ) {
            bb.flip();

            CharBuffer cb = cs.decode(bb);
            while (cb.hasRemaining()) {
                System.out.print(cb.get());
            }
            System.out.println();
            bb.clear();
        }

    }
}
