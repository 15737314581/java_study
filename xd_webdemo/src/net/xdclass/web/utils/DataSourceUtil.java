package net.xdclass.web.utils;


import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * 数据库连接池工具类
 */
public class DataSourceUtil {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBCP失败");
        }
    }

    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

}
