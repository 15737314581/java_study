package net.xdclass.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@WebServlet("/fileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        System.out.println("username=" + username);
        Part part = req.getPart("img");
        String header = part.getHeader("content-disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=") + 10, header.length() - 1);
        System.out.println("filename=" + filename);
        InputStream is = part.getInputStream();
        String dir = this.getServletContext().getRealPath("/file");
        File dirfile = new File(dir);
        if (!dirfile.exists()) {
            dirfile.mkdirs();
        }

        String realFileName = UUID.randomUUID() + filename;
        File file = new File(dir, realFileName);
        FileOutputStream fos = new FileOutputStream(file);
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        fos.close();
        is.close();
        req.getRequestDispatcher("/file/"+realFileName).forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
