package cn.itcast.jdbctemplate;

import cn.itcast.datasource.until.JDBCUtils;
import cn.itcast.domain.Goods;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo02 {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test1() {
        String sql = "update goods set price = ? where id = ?";
        int count = template.update(sql, "2000", 22);
        System.out.println(count);
    }

    @Test
    public void test2(){
        String sql = "insert into goods (name,price) values (?,?)";
        int count = template.update(sql, "ЪѓБъ", 150);
        System.out.println(count);
    }

    @Test
    public void test3(){
        String sql = "delete from goods where id = ?";
        int count = template.update(sql, 25);
        System.out.println(count);
    }

    @Test
    public void test4(){
        String sql = "select * from goods";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> objectMap : list) {
            System.out.println(objectMap);
        }
    }

    @Test
    public void test5(){
        String sql = "select * from goods";
        List<Goods> list = template.query(sql, new BeanPropertyRowMapper<Goods>(Goods.class));
        for (Goods goods : list) {
            System.out.println(goods);
        }
    }

    @Test
    public void test6(){
        String sql = "select count(id) from goods";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
