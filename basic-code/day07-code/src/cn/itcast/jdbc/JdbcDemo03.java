package cn.itcast.jdbc;

import java.sql.*;

public class JdbcDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///jing_dong", "root", "root");
            stmt = conn.createStatement();
//
            String sql = "select * from goods";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.println(id + "-----" + name + "-----" + price);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
