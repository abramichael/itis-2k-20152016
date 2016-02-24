import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ma on 18.02.2016.
 */
public class FunnyDB {
    public static Connection getConn() throws SQLException {
        Connection conn = mock(Connection.class);
        Statement st = mock(Statement.class);
        when(conn.createStatement()).thenReturn(st);
        ResultSet rs = mock(ResultSet.class);
        when(st.executeQuery(anyString())).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, true, false);
        when(rs.getString(1)).thenReturn("1","2","3");
        when(rs.getString(2)).thenReturn("Kostya", "Danil", "Almaz");
        return conn;
    }


}
