package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    public void loginTest(){
        User loginuser = new User();
        loginuser.setUsername("zhangsan");
        loginuser.setPassword("112233");

        UserDao userDao = new UserDao();
        User user = userDao.login(loginuser);
        System.out.println(user);
    }
}
