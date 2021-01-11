package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo02 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request增强
        System.out.println("来的时候拦截");
        chain.doFilter(req, resp);
        //对respose增强
        System.out.println("回去的时候拦截");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
