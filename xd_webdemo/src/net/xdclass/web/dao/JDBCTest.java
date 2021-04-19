package net.xdclass.web.dao;


import sun.dc.pr.PRError;

import java.sql.*;


public class JDBCTest {
    public static void main(String[] args) throws Exception {
        // testQuerySql();
        // testAddSql();
        // testDeleteSql();
        testTransaction();
    }

    public static void testQuerySql() throws Exception {
        // 加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");

        // 建⽴立数据库连接Connection
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 创建执⾏行行SQL的语句Statement
//        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and pwd = ?");
        String name = "jack";
        String pwd = "666";
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);

        ResultSet resultSet = preparedStatement.executeQuery();

        // 处理理执⾏行行结果ResultSet
        while (resultSet.next()) {
            System.out.println("用户名称：" + resultSet.getString("username") + "  联系方式：" + resultSet.getString("wechat"));
        }

        // 释放连接资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    public static void testAddSql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user (username,pwd,sex,role,create_time) values (?,?,?,?,?)");
        preparedStatement.setString(1, "tom");
        preparedStatement.setString(2, "123");
        preparedStatement.setInt(3, 1);
        preparedStatement.setInt(4, 2);
        preparedStatement.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public static void testDeleteSql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id = ?");
        preparedStatement.setInt(1,6);
        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public static void testTransaction() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/xd_web?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection connection = DriverManager.getConnection(url, username, password);
        try(PreparedStatement ps1 = connection.prepareStatement("insert into user (username,pwd) values (?,?)");
            PreparedStatement ps2 = connection.prepareStatement("insert into user (username,pwd) values (?,?)")
            ) {
            connection.setAutoCommit(false);
            ps1.setString(1, "tom1");
            ps1.setString(2, "123");

            ps2.setString(1, "tom2");
            ps2.setString(2, "123");

            ps1.execute();
            int i= 1/0;
            ps2.execute();

        } catch (Exception e){
            e.printStackTrace();
            connection.rollback();

        } finally {
            connection.commit();
            connection.close();
        }
    }

}
