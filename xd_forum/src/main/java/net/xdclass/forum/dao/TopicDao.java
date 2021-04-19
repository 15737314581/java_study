package net.xdclass.forum.dao;


import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.utli.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class TopicDao {
    QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
    // 驼峰映射
    BeanProcessor beanProcessor = new GenerousBeanProcessor();
    RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * 根据id查询主题分页总条数
     * @param cId
     * @return
     */
    public int countTotalRecord(int cId) {
        String sql = "select count(*) from topic where c_id = ? and 'delete' = 0";
        Long totalRecord = null;
        try {
            totalRecord = (Long) queryRunner.query(sql, new ScalarHandler<>(), cId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRecord.intValue();
    }

    /**
     * 主题分页查询
     * @param cId
     * @param from
     * @param pageSize
     * @return
     */
    public List<Topic> topicListByid(int cId, int from, int pageSize) {
        String sql = "select * from topic where c_id = ? and 'delete' = 0 order by id limit ?,?";
        List<Topic> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<>(Topic.class, processor), cId, from, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据id查询主题详情
     * @param topicId
     * @return
     */
    public Topic findTopicById(int topicId){
        String sql = "select * from topic where id = ?";
        Topic topic = null;
        try {
            topic = queryRunner.query(sql, new BeanHandler<>(Topic.class, processor), topicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topic;
    }
}
