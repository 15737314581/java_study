package net.xdclass.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("onlineNum", 0);
        sc.setAttribute("totalVisit", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
