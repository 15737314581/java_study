package net.xdclass.forum.service.impl;

import net.xdclass.forum.dao.ReplyDao;
import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.ReplyService;

import java.util.List;

public class ReplyServiceImpl implements ReplyService {
    ReplyDao replyDao = new ReplyDao();
    @Override
    public PageDTO<Reply> findReply(int topicId, int page, int pageSize) {
        int totalReplyRecord = replyDao.countReplyByTopicId(topicId);
        int from = (page-1) * pageSize;
        List<Reply> replyList = replyDao.findReplyByTopicId(topicId, from, pageSize);
        PageDTO<Reply> pageDTO = new PageDTO<>(page,pageSize,totalReplyRecord);
        pageDTO.setList(replyList);
        return pageDTO;
    }
}
