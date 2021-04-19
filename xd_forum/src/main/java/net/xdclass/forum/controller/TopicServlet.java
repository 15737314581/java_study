package net.xdclass.forum.controller;

import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.dto.PageDTO;
import net.xdclass.forum.service.TopicService;
import net.xdclass.forum.service.impl.TopicServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "topicServlet", urlPatterns = {"/topic"})
public class TopicServlet extends BaseServlet {

    TopicService topicService = new TopicServiceImpl();
    // 默认分页大小
    private static final int pageSize = 2;

    /**
     * topic分页接口
     * @param req
     * @param resp
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {

        int page = 1;
        int cId = Integer.parseInt(req.getParameter("c_id"));
        String currentPage = req.getParameter("page");
        if (currentPage != null && !"".equals(currentPage)) {
            page = Integer.parseInt(currentPage);
        }
        PageDTO<Topic> topicPageDTO = topicService.list(cId, page, pageSize);
        System.out.println(topicPageDTO.toString());
        req.setAttribute("topicPage", topicPageDTO);

    }
}
