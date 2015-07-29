import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class TestServlet extends HttpServlet {
    public static final String FORM = "<form action=\"formHandler\" method=\"POST\">" +
            "<input name=\"a1\" type=\"text\">" +
            "<input type=\"submit\">" +
            "</form>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html><head><title>Заголовок</title></head><body><h1>Пример сервлета</h1>");
            out.print(FORM);
            out.println("</body></html>");
            out.println(request.getContextPath() + "<br>");
            out.println(request.getServletPath() + "<br>");
            out.println(request.getParameterMap().values() + "<br>");


            out.println(request.getParameter("q") + "<br>");
            out.println(request.getParameterValues("q") + "<br>");
        } finally {
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Пример сервлета";
    }
}

