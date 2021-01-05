package cn.itcast.jdbc;

import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�������û�����");
        String username = sc.next();
        System.out.println("���������룺");
        String password = sc.next();
        boolean flag = new JdbcDemo07().login2(username, password);
        if (flag){
            System.out.println("��¼�ɹ�");
        } else {
            System.out.println("��¼ʧ��");
        }
    }

    public boolean login2(String username, String password){
        if (username == null || password == null){
            return false;
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,pstmt,conn);
        }


        return false;
    }
}
