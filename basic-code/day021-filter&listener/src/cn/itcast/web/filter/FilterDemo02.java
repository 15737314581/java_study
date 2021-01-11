package cn.itcast.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo02 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //��request��ǿ
        System.out.println("����ʱ������");
        chain.doFilter(req, resp);
        //��respose��ǿ
        System.out.println("��ȥ��ʱ������");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
