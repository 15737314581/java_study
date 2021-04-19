package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.ReplyService;
import net.xdclass.forum.service.TopicService;
import net.xdclass.forum.service.impl.ReplyServiceImpl;
import net.xdclass.forum.service.impl.TopicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "replyServlet", urlPatterns = {"/reply"})
public class ReplyServlet extends BaseServlet {
    private static final int pageSize = 2;
    ReplyService replyService = new ReplyServiceImpl();
    TopicService topicService = new TopicServiceImpl();

    public void list(HttpServletRequest req, HttpServletResponse resp){
        int topicId = Integer.parseInt(req.getParameter("topic_id"));
        int page = 1;
        String currentpage = req.getParameter("page");

        if (currentpage != null && !"".equals(currentpage)){
            page = Integer.parseInt(currentpage);
        }
        PageDTO<Reply> replyPageDTO = replyService.findReply(topicId, page, pageSize);
        Topic topic = topicService.findTopicById(topicId);
        System.out.println(replyPageDTO.toString());
        req.setAttribute("replyPage",replyPageDTO);
        req.setAttribute("topic",topic);
    }
}
