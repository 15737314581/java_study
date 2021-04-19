package net.xdclass.web.listener;

import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext sc = sre.getServletContext();
        Integer totalVisit = (Integer)sc.getAttribute("totalVisit");
        totalVisit++;
        sc.setAttribute("totalVisit",totalVisit);
    }
}
