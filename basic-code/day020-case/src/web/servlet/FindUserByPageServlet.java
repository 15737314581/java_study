package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ���
        request.setCharacterEncoding("utf-8");
        //��ȡ����
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        Map<String, String[]> condition = request.getParameterMap();
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }
        //����Service
        UserService userService = new UserServiceImpl();
        PageBean<User> pb = userService.finUserByPage(currentPage,rows,condition);
        System.out.println(pb);
        //��PageBean����request��
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//��condition����request��
        //ת����list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
