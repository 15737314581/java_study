package cn.itcast.datasource.druid;

import cn.itcast.datasource.until.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtils.getConnect();
            String sql = "insert into user values (null,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"wangwu");
            pstmt.setString(2,"789");
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
