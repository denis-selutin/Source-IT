import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class ShowSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer count = (Integer)session.getAttribute("counter");
        if(count == null) {
            count = new Integer(0);
        }
        count++;
        session.setAttribute("counter", count);

        PrintWriter out = resp.getWriter();
        out.write("<html><body>");
        out.write("<br>Counter = " + count);
        out.write("</html></body>");
    }
}
