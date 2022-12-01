package Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import  javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import  javax.servlet.http.HttpSessionEvent;
import  javax.servlet.http.HttpSessionListener;
import javax.swing.*;

@WebListener()
public class SessionListener implements HttpSessionListener {

    public SessionListener(){
    }
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent){
        HttpSession session= httpSessionEvent.getSession();
        ServletContext inform=session.getServletContext();
        Integer count=(Integer) inform.getAttribute("onlineCount");//获取onlineCount，没有则创建
        if(count==null){
            count=1;
        }
        else {
            count++;
        }
        inform.setAttribute("onlineCount",count);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent){
        ServletContext inform=httpSessionEvent.getSession().getServletContext();
        Integer count=(Integer) inform.getAttribute("onlineCount");
        if(count==null){
            count=0;
        }
        else {
            count--;
        }
        inform.setAttribute("onlineCount",count);
    }

}
