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
        //������֤��ͼƬ����
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);

        //����ͼƬ
        //��ȡ���ʶ���
        Graphics g = image.getGraphics();
        //��䱳��ɫ
        g.setColor(Color.gray);
        g.fillRect(0,0,width,height);
        //���ñ߿�
        g.setColor(Color.green);
        g.drawRect(0,0,width-1,height-1);
        //��������ַ�
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());//����Ǳ�
            char c = str.charAt(index);
            g.drawString(c+"",(width/5)*i,height/2);
            sb.append(c);
        }
        String checkcode_session = sb.toString();
        request.getSession().setAttribute("checkcode_session",checkcode_session);
        //��������
        g.setColor(Color.green);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }

        //��ͼƬ�����ҳ��չʾ
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
