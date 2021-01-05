package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    /**
     * 1. 案例需求：
     * 		1. 访问带有验证码的登录页面login.jsp
     * 		2. 用户输入用户名，密码以及验证码。
     * 			* 如果用户名和密码输入有误，跳转登录页面，提示:用户名或密码错误
     * 			* 如果验证码输入有误，跳转登录页面，提示：验证码错误
     * 			* 如果全部输入正确，则跳转到主页success.jsp，显示：用户名,欢迎您
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        //获取验证码
        HttpSession session = request.getSession();
        String checkcode_session = (String) session.getAttribute("checkcode_session");
        //删除验证码
        session.removeAttribute("checkcode_session");
        //判断验证码
        if (checkcode_session != null && checkcode_session.equalsIgnoreCase(checkcode)){
            //判断用户名和密码
            if ("zhangsan".equals(username) && "112233".equals(password)) {
                //储存信息，用户信息
                session.setAttribute("user",username);
                //重定向进入成功页
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            } else {
                //登录失败
                request.setAttribute("login_error","用户名密码错误");
                //转发到登录页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } else {
            //验证码不一致
            //存储提示信息到request
            request.setAttribute("msg_error","验证码错误");
            //转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
