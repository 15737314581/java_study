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
        //���ñ���
        request.setCharacterEncoding("utf-8");
        /**
        //��ȡ����
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //��װuser����
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
         */
        //��ȡ���в���
        Map<String, String[]> map = request.getParameterMap();
        //��װuser����
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //����UserDao��login����
        UserDao userDao = new UserDao();
        User user = userDao.login(loginuser);
        //�ж�user
        if (user != null){
            //��¼�ɹ�
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        } else{
            //��¼ʧ��
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
