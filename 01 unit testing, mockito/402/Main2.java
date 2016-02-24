import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ma on 18.02.2016.
 */
public class Main2 {
    public static void main(String[] args) throws IOException, SQLException {
        InputStream is = mock(InputStream.class);
        when(is.read()).thenReturn(5, 6, 8, 2, 8, 45, 8, 4);
        when(is.available()).thenReturn(1, 1, 1, 1, 1, 1, -1);
        when(is.available()).thenReturn(1, 1, 1, 1, 1, 1, -1);


        while (is.available() != -1) {
            System.out.println(is.read());
        }

        Connection conn = FunnyDB.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from people");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }










    }
}
