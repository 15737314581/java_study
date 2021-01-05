package cn.itcast.datasource.until;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdk.nashorn.internal.scripts.JD;

import javax.sql.DataSource;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnect() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Statement stmt, Connection coon){
//        if (stmt != null){
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (coon != null){
//            try {
//                coon.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        close(null,stmt,coon);
    }

    public static void close(ResultSet rs, Statement stmt, Connection coon){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (coon != null){
            try {
                coon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
