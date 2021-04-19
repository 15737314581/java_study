package net.xdclass.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(filterName = "loginFilter", urlPatterns = {"/user/*"}, initParams = {
//        @WebInitParam(name = "encoding", value = "UTF-8"),
//        @WebInitParam(name = "loginPage", value = "/login.jsp")
//})
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;
    private String encoding;
    private String loginPage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if (req.getSession().getAttribute("login_user") != null){
            chain.doFilter(request,response);
        }else {
            req.setAttribute("msg","非法访问，请登录");
            req.getRequestDispatcher(loginPage).forward(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
