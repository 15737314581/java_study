package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    /**
     * 查询功能
     * @return
     */
    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    /**
     * 完成登录功能
     * @param user
     * @return
     */
    @Override
    public User login(User  user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     * 添加功能
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    /**
     * 删除功能
     * @param id
     */
    @Override
    public void delUser(String id) {
        dao.del(Integer.parseInt(id));
    }

    /**
     * 回显数据
     * @return
     */
    @Override
    public User findUser(String id) {
        return dao.find(Integer.parseInt(id));
    }

    /**
     * 修改数据
     * @param user
     */
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    /**
     * 批量删除
     *
     * @param uids
     */
    @Override
    public void delSelected(String[] uids) {
        for (String id : uids) {
            dao.del(Integer.parseInt(id));
        }
    }

    /**
     * 分页查询
     * @param _currentPage
     * @param _rows
     * @param condition
     * @return
     */
    @Override
    public PageBean<User> finUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <= 0) {
            currentPage = 1;
        }

        //创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        //设置参数

        pb.setRows(rows);
        //调用dao方法查询totalCount总记录数；
        int totalCont = dao.findTotalCount(condition);
        pb.setTotalCount(totalCont);
        //计算起始数start
        int start = (currentPage - 1) * rows;
        //调用dao方法查询每页的数据集合list
        List<User> list =  dao.findByPage(start,rows,condition);
        pb.setList(list);
        //判断并设置totalPage
        int totalPage = (totalCont % rows) == 0 ? totalCont/rows : (totalCont/rows) + 1;
        pb.setTotalpage(totalPage);

        System.out.println(currentPage);
        pb.setCurrentPage(currentPage);
        return pb;
    }
}
