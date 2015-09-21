import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,
							HttpServletResponse resp)
								throws ServletException, IOException {

		resp.setContentType("text/html");
		String name = req.getParameter("name");
		PrintWriter pw = resp.getWriter();
		if (name != null) {
			pw.println("Hi, <b>" + name + "</b>");
		}
		pw.println("<form method='get' action='/hello'>");
		pw.println("<input type='text' name='name' />");
		pw.println("<input type='submit' value='say hi' />");
		pw.println("</form>");
		pw.close();
	}

}