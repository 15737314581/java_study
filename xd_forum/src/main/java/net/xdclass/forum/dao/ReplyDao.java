package net.xdclass.forum.dao;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.utli.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ReplyDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    // 驼峰映射
    private BeanProcessor beanProcessor = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor(beanProcessor);

    /**
     * 根据主题id查询回复总数
     *
     * @param topicId
     * @return
     */
    public int countReplyByTopicId(int topicId) {
        String sql = "select count(*) from reply where topic_id = ?";
        Long totalReplyRecord = null;
        try {
            totalReplyRecord = (Long) queryRunner.query(sql, new ScalarHandler<>(), topicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalReplyRecord.intValue();
    }

    /**
     * 根据主题id查询回复列表
     * @param topicId
     * @param from
     * @param pageSize
     * @return
     */
    public List<Reply> findReplyByTopicId(int topicId, int from, int pageSize) {
        String sql = "select * from reply where topic_id = ? order by create_time desc limit ?,?";
        List<Reply> replylsit = null;
        try {
            replylsit = queryRunner.query(sql, new BeanListHandler<>(Reply.class, processor), topicId, from, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return replylsit;

    }

}
