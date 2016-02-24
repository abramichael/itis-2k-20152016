import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ma on 19.02.2016.
 */
public class Main2 {
    public static void main(String[] args) throws IOException, SQLException {


        InputStream is = mock(InputStream.class);
        when(is.available()).thenReturn(0,0,0,0,0,0,0,0,0,-1);
        when(is.read()).thenReturn(4,5,3,5,2,4,2,24,1,3,1);

        int s = 0;
        while (is.available() != -1) {
            s += is.read();
        }
        System.out.println(s);


        Connection conn = FunnyDB.getConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from students");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }




    }


}
