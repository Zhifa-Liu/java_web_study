package test.filtertest;

import javax.servlet.*;
import java.io.IOException;

public class Filter_1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Begin-1");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("End-1");
    }

    @Override
    public void destroy() {

    }
}
