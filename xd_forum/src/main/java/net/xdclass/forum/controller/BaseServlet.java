package net.xdclass.forum.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "baseServlet")
public class BaseServlet extends HttpServlet {
    /**
     * 子类的servlet被访问，会调用service方法，子类没有重写，会调用父类的service方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if (method != null) {
            try {
                Method targetMethod = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
                targetMethod.invoke(this,req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
