import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ma on 30.09.2015.
 */
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException, ServletException {

        resp.getWriter().println("Hello, anon!");

    }

    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException, ServletException {


    }
}
