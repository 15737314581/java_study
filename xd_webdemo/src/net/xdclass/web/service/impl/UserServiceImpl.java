package net.xdclass.web.service.impl;

import net.xdclass.web.dao.UserDao;
import net.xdclass.web.domain.User;
import net.xdclass.web.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();
    @Override
    public User findByid(int id) {
        User user = userDao.findByid(id);
        return user;
    }

    @Override
    public List<User> list() {
       return userDao.list();
    }

    @Override
    public Map<String, Object> map(int id) {
        return userDao.map(id);
    }

    @Override
    public List<Map<String, Object>> listWithMap() {
        return userDao.listWithMap();
    }

    @Override
    public Long count() {
        return userDao.count();
    }

    @Override
    public int save(User user) {
        return userDao.save(user);
    }
}
