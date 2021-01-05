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
     * 1. ��������
     * 		1. ���ʴ�����֤��ĵ�¼ҳ��login.jsp
     * 		2. �û������û����������Լ���֤�롣
     * 			* ����û�������������������ת��¼ҳ�棬��ʾ:�û������������
     * 			* �����֤������������ת��¼ҳ�棬��ʾ����֤�����
     * 			* ���ȫ��������ȷ������ת����ҳsuccess.jsp����ʾ���û���,��ӭ��
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //����request����
        request.setCharacterEncoding("utf-8");
        //��ȡ�������
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        //��ȡ��֤��
        HttpSession session = request.getSession();
        String checkcode_session = (String) session.getAttribute("checkcode_session");
        //ɾ����֤��
        session.removeAttribute("checkcode_session");
        //�ж���֤��
        if (checkcode_session != null && checkcode_session.equalsIgnoreCase(checkcode)){
            //�ж��û���������
            if ("zhangsan".equals(username) && "112233".equals(password)) {
                //������Ϣ���û���Ϣ
                session.setAttribute("user",username);
                //�ض������ɹ�ҳ
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            } else {
                //��¼ʧ��
                request.setAttribute("login_error","�û����������");
                //ת������¼ҳ��
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        } else {
            //��֤�벻һ��
            //�洢��ʾ��Ϣ��request
            request.setAttribute("msg_error","��֤�����");
            //ת������¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
