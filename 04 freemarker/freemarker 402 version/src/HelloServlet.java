import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ma on 08.10.2015.
 */
@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Configuration cfg = ConfigSingleton.getConfig(getServletContext());
        Template tmpl = cfg.getTemplate("hello.ftl");
        HashMap<String, Object> root = new HashMap<>();
        root.put("form_url", request.getRequestURI());
        root.put("username", request.getParameter("name"));
        ArrayList<String> greetings = new ArrayList<>();
        greetings.add("Ni Hao");
        greetings.add("Isenmesez");
        greetings.add("Merhaba");
        greetings.add("Salam aleykum");
        greetings.add("Jambo");
        greetings.add("Bonjour");
        greetings.add("Shalom");
        root.put("greetings", greetings);
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
