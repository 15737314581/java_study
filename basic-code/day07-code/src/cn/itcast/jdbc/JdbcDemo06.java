package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�������û�����");
        String username = sc.next();
        System.out.println("���������룺");
        String password = sc.next();
        boolean flag = new JdbcDemo06().login(username, password);
        if (flag){
            System.out.println("��¼�ɹ�");
        } else {
            System.out.println("��¼ʧ��");
        }
    }

    public boolean login(String username, String password){
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username='" + username +"' and password='" + password + "'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }


        return false;
    }
}
