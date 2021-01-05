package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    /**
     * ��¼����
     * @param loginuser ֻ���û���������
     * @return �����û�����������
     */

    //����JdbcTemplate���󹫹�ʹ��
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User loginuser){
        //��дsql
        try {
            String sql = "select * from user where username = ? and password = ?";
            //����query����
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginuser.getUsername(),
                    loginuser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
