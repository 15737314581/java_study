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
     * ��ѯ����
     * @return
     */
    @Override
    public List<User> findAll() {
        //����Dao��ɲ�ѯ
        return dao.findAll();
    }

    /**
     * ��ɵ�¼����
     * @param user
     * @return
     */
    @Override
    public User login(User  user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     * ��ӹ���
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    /**
     * ɾ������
     * @param id
     */
    @Override
    public void delUser(String id) {
        dao.del(Integer.parseInt(id));
    }

    /**
     * ��������
     * @return
     */
    @Override
    public User findUser(String id) {
        return dao.find(Integer.parseInt(id));
    }

    /**
     * �޸�����
     * @param user
     */
    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    /**
     * ����ɾ��
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
     * ��ҳ��ѯ
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

        //�����յ�PageBean����
        PageBean<User> pb = new PageBean<>();
        //���ò���

        pb.setRows(rows);
        //����dao������ѯtotalCount�ܼ�¼����
        int totalCont = dao.findTotalCount(condition);
        pb.setTotalCount(totalCont);
        //������ʼ��start
        int start = (currentPage - 1) * rows;
        //����dao������ѯÿҳ�����ݼ���list
        List<User> list =  dao.findByPage(start,rows,condition);
        pb.setList(list);
        //�жϲ�����totalPage
        int totalPage = (totalCont % rows) == 0 ? totalCont/rows : (totalCont/rows) + 1;
        pb.setTotalpage(totalPage);

        System.out.println(currentPage);
        pb.setCurrentPage(currentPage);
        return pb;
    }
}
