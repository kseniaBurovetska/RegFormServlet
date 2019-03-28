package command;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "/views/registration.jsp";
    }
}
