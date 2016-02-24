import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by ma on 30.09.2015.
 */
@WebFilter(filterName = "AnonFilter")
public class AnonFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession hs = ((HttpServletRequest)req).getSession();
        if (hs.getAttribute("current_user") == null) {
            ((HttpServletResponse)resp).sendRedirect("/anon");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
