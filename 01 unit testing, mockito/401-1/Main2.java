

import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import static org.mockito.Mockito.*;

/**
 * Created by ma on 17.02.2016.
 */
public class Main2 {

    public static void main(String[] args) throws IOException, SQLException {

        InputStream is = mock(InputStream.class);
        System.out.println(is.available());
        System.out.println(is.read());

        when(is.read()).thenReturn(6, 3, 6, 3, 7, 4, 9, 3);
        System.out.println(is.read());
        System.out.println(is.read());
        //verify(is, times(2)).read();
        when(is.skip(anyLong())).thenReturn(100L);

        Connection conn = FunnyDB.getDBConn();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from ...");
        while (rs.next()){
            System.out.println(rs.getString("id") + " " + rs.getString("name"));
        }
        verify(rs, atLeast(2)).next();

        List items = new LinkedList();
        List spyItems = spy(items);

        when(spyItems.size()).thenReturn(100);
        spyItems.add(1);
        spyItems.add("abc");
        System.out.println(spyItems.get(0));
        System.out.println(spyItems.size());
        System.out.println(spyItems.get(2));

    }
}
