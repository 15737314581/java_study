package net.xdclass.web.controller;

import net.xdclass.web.utils.CustomDBUtil;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/jdbc")
public class TestJdbcServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str_id = req.getParameter("id");
        int id = Integer.parseInt(str_id);
        try {
            Connection connection = CustomDBUtil.getConnection();
            PreparedStatement psmt = connection.prepareStatement("select * from user where id = ?");
            psmt.setInt(1,id);
            ResultSet resultSet = psmt.executeQuery();
            while (resultSet.next()){
                System.out.println("用户名称："+resultSet.getString("username")+"  联系方式："+resultSet.getString("pwd"));
            }
            CustomDBUtil.close(resultSet, psmt, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
