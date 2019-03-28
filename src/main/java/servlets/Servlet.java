package servlets;

import command.Command;
import command.Login;
import command.Registration;
import command.ViewAll;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Servlet extends HttpServlet {

    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private Map<Integer, User> users;
    private AtomicInteger id;

    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");

        if (users == null) {
            throw new IllegalStateException("Users array is null");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }

        id = new AtomicInteger(((ConcurrentHashMap<Integer, User>) users).size());

        commands.put("viewAll", new ViewAll());
        commands.put("registration", new Registration());
        commands.put("login", new Login());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = (req.getParameter("firstName"));
        String lastName = (req.getParameter("lastName"));
        String login = (req.getParameter("regLogin"));
        String email = (req.getParameter("email"));
        final int id = this.id.incrementAndGet();
        users.put(id, new User(firstName, lastName, login, email));
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        for(User user: users.values()){
            System.out.println(user);
        }

        String path = req.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        Command command = commands.getOrDefault(path, new Login());

        System.out.println(path);

        String page = command.execute(req);
        if (page.contains("redirect")) {
            req.getRequestDispatcher(page.replace("redirect:", "")).forward(req, resp);
        } else {
            req.getRequestDispatcher(page).forward(req, resp);
        }
    }

}
