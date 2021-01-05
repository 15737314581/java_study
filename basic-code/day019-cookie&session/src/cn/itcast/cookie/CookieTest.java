package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    /**
     *1. ���Բ���Cookie�����
     *2. �ڷ������е�Servlet�ж��Ƿ���һ����ΪlastTime��cookie
     * 	1. �У����ǵ�һ�η���
     * 	      1. ��Ӧ���ݣ���ӭ���������ϴη���ʱ��Ϊ:2018��6��10��11:50:20
     * 		  2. д��Cookie��lastTime=2018��6��10��11:50:01
     * 	2. û�У��ǵ�һ�η���
     * 		  1. ��Ӧ���ݣ����ã���ӭ���״η���
     * 		  2. д��Cookie��lastTime=2018��6��10��11:50:01
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //��ȡ����cookie����
        Cookie[] cookies = request.getCookies();
        Boolean flag = false;
        //����cookies
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //��ȡcookie�ļ�
                String name = cookie.getName();
                //�ж��Ƿ���һ����ΪlastTime��cookie
                if ("lastTime".equals(name)){
                    flag = true;
                    //1.��Ӧ����
                    String value = cookie.getValue();
                    //URL����
                    System.out.println("����ǰ��"+value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("�����"+value);
                    response.getWriter().write("<h1>��ӭ���������ϴη���ʱ��Ϊ:"+value+"</h1>");
                    //2.д��Cookie��lastTime=
                    Date date = new Date();
                    SimpleDateFormat spf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
                    String new_date = spf.format(date);
                    //url����
                    System.out.println("����ǰ��"+new_date);
                    new_date = URLEncoder.encode(new_date, "utf-8");
                    System.out.println("�����"+new_date);
                    cookie.setValue(new_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;
                }

            }
        }
        if (cookies == null || cookies.length == 0 || flag == false){
            //1. ��Ӧ����
            response.getWriter().write("<h1>���ã���ӭ���״η���</h1>");
            //2. д��Cookie
            Date date = new Date();
            SimpleDateFormat spf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
            String new_date = spf.format(date);
            //url����
            System.out.println("����ǰ��"+new_date);
            new_date = URLEncoder.encode(new_date, "utf-8");
            System.out.println("�����"+new_date);
            Cookie cookie = new Cookie("lastTime",new_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            Cookie[] cookies1 = request.getCookies();
            for (Cookie cookie1 : cookies1) {
                String name = cookie1.getName();
                String value = cookie1.getValue();
                System.out.println(name+":"+value);
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
