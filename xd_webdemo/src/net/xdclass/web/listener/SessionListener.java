package net.xdclass.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer onlineNum = (Integer) sc.getAttribute("onlineNum");
        onlineNum++;
        sc.setAttribute("onlineNum", onlineNum);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer onlineNum = (Integer) sc.getAttribute("onlineNum");
        onlineNum--;
        sc.setAttribute("onlineNum", onlineNum);
    }
}
