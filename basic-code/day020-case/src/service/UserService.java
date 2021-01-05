package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * �û������ҵ��ӿ�
 */

public interface UserService {
    public List<User> findAll();
    public User login(User  user);


    void addUser(User user);

    void delUser(String id);

    User findUser(String id);

    void updateUser(User user);

    void delSelected(String[] uids);

    PageBean<User> finUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
