package cn.itcast.jdbctemplate;

import cn.itcast.datasource.until.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update user set password = ? where id = 3 ";
        int count = template.update(sql, "999");
        System.out.println(count);
    }
}
