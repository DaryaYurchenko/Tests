package controller.command;

import controller.command.result.CommandResult;
import controller.pages.CommandPages;
import model.service.UserService;
import model.service.factory.ServiceFactory;
import model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class DeleteUserById  extends Command implements CommandPages {

    private UserService userService;

    public DeleteUserById() {
        this.userService = ServiceFactory.getInstance().getUserService();
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        Optional<String> optId = Optional.ofNullable(req.getParameter("radio"));
        if(optId.isPresent()) {
            Long userId = Long.parseLong(req.getParameter("radio"));
            userService.deleteUserById(userId);
            return CommandResult.forward(new ShowAllUsers());
        }
        return CommandResult.forward(new ShowAllUsers());

    }
}
