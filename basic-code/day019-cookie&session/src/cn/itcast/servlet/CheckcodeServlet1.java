package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcodeServlet1")
public class CheckcodeServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 200;
        int height = 50;
        //创建验证码图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //绘制图片
        //获取画笔对象
        Graphics g = image.getGraphics();
        //填充背景色
        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);
        //设置边框
        g.setColor(Color.green);
        g.drawRect(0,0,width-1,height-1);
        //生成随机字符
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());//随机角标
            char c = str.charAt(index);
            g.drawString(c+"",(width/5)*i,height/2);
            sb.append(c);
        }
        String checkcode_session = sb.toString();
        request.getSession().setAttribute("checkcode_session",checkcode_session);
        //画干扰线
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
