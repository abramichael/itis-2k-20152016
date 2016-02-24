import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by ma on 22.10.2015.
 */
@WebServlet(name = "StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
    Connection conn;
    public void init(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/virtual_schools",
                    "postgres",
                    "postgres"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select name from students where name like ?"
            );
            ps.setString(1, "%" + q + "%");
            ResultSet rs = ps.executeQuery();
            JSONArray ja = new JSONArray();
            while (rs.next()){
                ja.put(rs.getString("name"));
            }
            JSONObject jo = new JSONObject();
            jo.put("results", ja);
            response.getWriter().print(jo.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
