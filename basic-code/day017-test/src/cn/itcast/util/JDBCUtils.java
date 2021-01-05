package cn.itcast.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC�����࣬ʹ��Durid���ӳ�
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        try {
            //���������ļ�
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            // ��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //��ȡ���ӳض���
    public static DataSource getDataSource(){
        return ds;
    }

    //��ȡ����connection����
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}