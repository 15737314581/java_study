package net.xdclass.web.dao;

import net.xdclass.web.domain.User;
import net.xdclass.web.utils.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class UserDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    // 开启驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    public User findByid(int id) {
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class, processor), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> list() {
        String sql = "select * from user";
        List<User> list = null;
        try {
            list = queryRunner.query(sql,new BeanListHandler<>(User.class,processor));
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Map<String,Object> map(int id) {
        String sql = "select * from user where id = ?";
        Map<String,Object> map = null;
        try {
            map = queryRunner.query(sql,new MapHandler(),id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    public List<Map<String,Object>> listWithMap() {
        String sql = "select * from user";
        List<Map<String,Object>> list = null;
        try {
            list = queryRunner.query(sql,new MapListHandler());
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Long count(){
        String sql = "select count(*) from user";
        Long num = null;
        try {
            num = queryRunner.query(sql,new ScalarHandler<>());
        } catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }

    public int save(User user){
        String sql = "insert into user (phone,pwd,sex,img,create_time,role,username,wechat) values (?,?,?,?,?,?,?,?)";
        int i = 0;
        Object[] params = {
                user.getPhone(),
                user.getPwd(),
                user.getSex(),
                user.getImg(),
                user.getCreateTime(),
                user.getRole(),
                user.getUsername(),
                user.getWechat()
        };
        try {
            i = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
