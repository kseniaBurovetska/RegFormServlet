package servlets;

import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.ConcurrentHashMap;

@WebListener
public class ContextListener implements ServletContextListener {

    private ConcurrentHashMap<Integer, User> users;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        users = new ConcurrentHashMap<>();
        users.put(1,new User("John", "Doe", "johnLogin", "johnEmail"));
        users.put(2,new User("Jane", "Smith", "janeLogin", "janeEmail"));
        users.put(3,new User("Sam", "Bean", "samLogin", "samEmail"));
        servletContext.setAttribute("users", users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        users = null;
    }
}
