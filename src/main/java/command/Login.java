package command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("login");
        String pass = request.getParameter("password");
        System.out.println(name + " " + pass);
        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/views/login.jsp";
        }

        return "/views/login.jsp";
    }
}
