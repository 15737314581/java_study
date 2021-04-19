package net.xdclass.web.servlet;

import net.xdclass.web.domain.User;
import net.xdclass.web.service.UserService;
import net.xdclass.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/test")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        UserService userService = new UserServiceImpl();
        if ("findByid".equals(method)) {
            String str_id = req.getParameter("id");
            int id = Integer.parseInt(str_id);
            User user = userService.findByid(id);
            System.out.println(user.toString());
        }
        if ("list".equals(method)) {
            List<User> list = userService.list();
            for (User user : list) {
                System.out.println(user);
            }
        }
        if ("map".equals(method)) {
            String str_id = req.getParameter("id");
            int id = Integer.parseInt(str_id);
            Map<String, Object> map = userService.map(id);
            System.out.println(map);
            System.out.println(map.get("username"));
        }
        if ("listWithMap".equals(method)) {
            List<Map<String, Object>> list = userService.listWithMap();
            for (Map<String, Object> stringObjectMap : list) {
                System.out.println(stringObjectMap);
            }
        }
        if ("count".equals(method)) {
            Long num = userService.count();
            System.out.println("user表行数：" + num);
        }
        if ("save".equals(method)) {
            User user = new User();
            user.setPhone(req.getParameter("phone"));
            user.setPwd(req.getParameter("pwd"));
            user.setSex(Integer.parseInt(req.getParameter("sex")));
            user.setImg(req.getParameter("img"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setCreateTime(simpleDateFormat.parse(req.getParameter("createTime")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setRole(Integer.parseInt(req.getParameter("role")));
            user.setUsername(req.getParameter("username"));
            user.setWechat(req.getParameter("wechat"));

            int i = userService.save(user);
            System.out.println("i= " + i);
            if (i == 1) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }
        }
    }
}
