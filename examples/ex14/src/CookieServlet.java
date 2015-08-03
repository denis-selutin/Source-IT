import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie c = new Cookie("someCookie", "123456");
        c.setSecure(true);
        c.setMaxAge(3600);
        c.setVersion(5);
        resp.addCookie(c);
        resp.sendRedirect("/ex14/index.jsp");
    }
}
