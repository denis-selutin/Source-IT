import sun.security.pkcs11.wrapper.Functions;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */
public class AppendFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("" + servletRequest.getAttribute("requestData"));
        AuthFilter.Auth auth = (AuthFilter.Auth) servletRequest.getAttribute("auth");
        if(auth != null) {
            UserDataRequest userDataRequest = new UserDataRequest(auth, servletRequest.getParameterMap());
            servletRequest.setAttribute("requestData", userDataRequest);
            ((HttpServletRequest)servletRequest).getSession().setAttribute("requestData", userDataRequest);

            servletRequest.removeAttribute("auth");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    public static class UserDataRequest {
        private Map<String, Object> params;
        private AuthFilter.Auth auth;

        public UserDataRequest(AuthFilter.Auth auth, Map params) {
            this.auth = auth;
            this.params = new HashMap<>(params);
        }

        @Override
        public String toString() {
            return "{UserDataRequest: {auth =" + this.auth + "; params=" + this.params.entrySet()
                    .stream()
                    .map(entry -> "" + entry.getKey() + "=" + entry.getValue())
                    .collect(Collectors.joining(",")) + "}";
        }
    }
}
