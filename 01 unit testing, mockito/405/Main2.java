import org.junit.runner.Result;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Main2 {
    public static void main(String[] args) throws IOException, SQLException {

        InputStream is = mock(InputStream.class);
        when(is.read()).thenReturn(200, 100, 50, 20);
        when(is.available()).thenReturn(4,3,2,1,0);

        // USAGE
        int s = 0;
        while (is.available() != 0) {
            s += is.read();
        }
        System.out.println(s);

        //with connection
        Connection conn = FunnyDB.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select ...");
        while (rs.next()){
            System.out.println(rs.getString("id") + " " + rs.getString("name"));
        }
    }
}
