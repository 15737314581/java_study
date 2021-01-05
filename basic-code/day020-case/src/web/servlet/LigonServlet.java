package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ligonServlet")
public class LigonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        String verifycode = request.getParameter("verifycode");
        Map<String, String[]> map = request.getParameterMap();
        //3.校验验证码
        HttpSession session = request.getSession();
        String checkcode_server =(String)session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            //校验失败
            //保存提示信息
            request.setAttribute("login_msg","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //4.封装user
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用service
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        //6.判断是否登录成功
        if (loginUser != null) {
            //登录成功
            //存储用户到session
            session.setAttribute("user",loginUser);
            //重定向进入index.jsp页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        } else {
            //校验失败
            //保存提示信息
            request.setAttribute("login_msg","用户名或密码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
