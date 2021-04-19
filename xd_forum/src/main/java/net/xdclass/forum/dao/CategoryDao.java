package net.xdclass.forum.dao;


import net.xdclass.forum.domain.Category;
import net.xdclass.forum.utli.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {

    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    // 驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * 返回全部分类
     * @return
     */
    public List<Category> list(){
        String sql = "select * from category";
        List<Category> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<>(Category.class, processor));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据id查询分类
     * @param id
     * @return
     */
    public Category findByid(int id){
        String sql = "select * from category where id = ?";
        Category category = null;
        try {
            category = queryRunner.query(sql, new BeanHandler<>(Category.class, processor), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

}
