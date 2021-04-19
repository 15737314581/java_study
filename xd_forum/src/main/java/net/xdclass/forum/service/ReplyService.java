package net.xdclass.forum.service;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.dto.PageDTO;

public interface ReplyService {
    PageDTO<Reply> findReply(int topicId, int page, int pageSize);
}
