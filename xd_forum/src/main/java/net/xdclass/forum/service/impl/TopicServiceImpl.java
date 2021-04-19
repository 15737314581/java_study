package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.TopicDao;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.TopicService;

import java.util.List;


public class TopicServiceImpl implements TopicService {

    TopicDao topicDao = new TopicDao();
    @Override
    public PageDTO<Topic> list(int cId, int page, int pageSize) {
        // 获取总行数
        int totalRecord = topicDao.countTotalRecord(cId);
        // 获取起始条数
        int from = (page-1) * pageSize;
        List<Topic> list = topicDao.topicListByid(cId, from, pageSize);
        PageDTO<Topic> pageDTO = new PageDTO<>(page,pageSize, totalRecord);
        pageDTO.setList(list);
        return pageDTO;
    }

    @Override
    public Topic findTopicById(int topicId) {
        Topic topic = topicDao.findTopicById(topicId);
        return topic;
    }
}
