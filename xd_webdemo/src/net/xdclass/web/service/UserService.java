package net.xdclass.web.service;

import net.xdclass.web.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findByid(int id);
    List<User> list();
    Map<String,Object> map(int id);
    List<Map<String,Object>> listWithMap();
    Long count();
    int save(User user);
}
