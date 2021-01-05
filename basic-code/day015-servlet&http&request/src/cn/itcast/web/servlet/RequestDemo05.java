package cn.itcast.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo05")
public class RequestDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        if (referer != null){
            if(referer.contains("/day015")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("正常路径.....");
//                System.out.println("正常路径.....");
            }else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("盗链......");
//                System.out.println("盗链......");
            }
        }

    }
}
