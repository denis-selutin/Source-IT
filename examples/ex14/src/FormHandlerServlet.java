import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class FormHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("<html><body>You have typed = \"" + req.getParameter("a1") + "\"");
        out.write("</br>Method = " + req.getMethod());
        out.write("</br>URI = " + req.getRequestURI());
        out.write("</br>Protocol = " + req.getProtocol());
        out.write("</br><a href=\"/ex14/test\">back</a>");
        out.write("</body></html>");

        System.out.println(req.getHeaderNames());

        resp.setIntHeader("myInt", 99);
        //resp.setContentType("text/xml");
        //resp.setHeader("Content-Type", "application/json");
        //resp.setHeader("Content-Type", "application/image");
        //see http://www.w3.org/Protocols/rfc1341/4_Content-Type.html
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
