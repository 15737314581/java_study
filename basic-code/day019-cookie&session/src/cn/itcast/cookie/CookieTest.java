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
     *1. 可以采用Cookie来完成
     *2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
     * 	1. 有：不是第一次访问
     * 	      1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
     * 		  2. 写回Cookie：lastTime=2018年6月10日11:50:01
     * 	2. 没有：是第一次访问
     * 		  1. 响应数据：您好，欢迎您首次访问
     * 		  2. 写回Cookie：lastTime=2018年6月10日11:50:01
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取所有cookie数据
        Cookie[] cookies = request.getCookies();
        Boolean flag = false;
        //遍历cookies
        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                //获取cookie的键
                String name = cookie.getName();
                //判断是否有一个名为lastTime的cookie
                if ("lastTime".equals(name)){
                    flag = true;
                    //1.响应数据
                    String value = cookie.getValue();
                    //URL解码
                    System.out.println("解码前："+value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后："+value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");
                    //2.写回Cookie：lastTime=
                    Date date = new Date();
                    SimpleDateFormat spf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String new_date = spf.format(date);
                    //url编码
                    System.out.println("编码前："+new_date);
                    new_date = URLEncoder.encode(new_date, "utf-8");
                    System.out.println("编码后："+new_date);
                    cookie.setValue(new_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                    break;
                }

            }
        }
        if (cookies == null || cookies.length == 0 || flag == false){
            //1. 响应数据
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
            //2. 写回Cookie
            Date date = new Date();
            SimpleDateFormat spf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String new_date = spf.format(date);
            //url编码
            System.out.println("编码前："+new_date);
            new_date = URLEncoder.encode(new_date, "utf-8");
            System.out.println("编码后："+new_date);
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
