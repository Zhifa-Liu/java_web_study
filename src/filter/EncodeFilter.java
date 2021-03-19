package filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodeFilter implements Filter {
    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encode);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
