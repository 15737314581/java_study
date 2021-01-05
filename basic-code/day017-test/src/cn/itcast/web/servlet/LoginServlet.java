package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        /**
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //封装user对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
         */
        //获取所有参数
        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginuser);
        //判断user
        if (user != null){
            //登录成功
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        } else{
            //登录失败
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
