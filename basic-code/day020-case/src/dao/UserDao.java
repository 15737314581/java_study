package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * �û�������Dao
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username,String password);

    void add(User user);

    void del(int id);

    User find(int id);

    void update(User user);


    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
