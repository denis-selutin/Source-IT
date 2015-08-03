import org.apache.catalina.filters.FilterBase;
import org.apache.juli.logging.Log;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import org.apache.juli.logging.LogFactory;

/**
 *
 */
public class AuthFilter extends FilterBase {
    public static final Log log = LogFactory.getLog(AuthFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest.getParameter("auth") != null) {
            //servletResponse.getWriter().append(servletRequest.getParameter("auth"));
            System.out.println(servletRequest.getAttributeNames());
            System.out.println(servletRequest.getParameter("auth"));
            servletRequest.setAttribute("auth", new Auth("some", "some name"));
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.getWriter().append("No auth");
        }
    }

    @Override
    protected Log getLogger() {
        return log;
    }

    public static class Auth {
        private String login;
        private String name;

        public Auth(String name, String login) {
            this.login = login;
            this.name = name;
        }

        @Override
        public String toString() {
            return "{Auth: " + this.login + "=" + this.name + "}";
        }
    }
}

