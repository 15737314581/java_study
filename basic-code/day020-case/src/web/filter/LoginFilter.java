package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取资源的请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录相关的请求路径
        if (uri.contains("/login.jsp") || uri.contains("/ligonServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet")){
            chain.doFilter(req, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute("login_msg","您尚未登录，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
