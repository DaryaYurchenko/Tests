package controller.command;

import controller.command.result.CommandResult;
import controller.pages.CommandPages;
import model.service.UserService;
import model.service.factory.ServiceFactory;
import model.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAllUsers extends Command implements CommandPages {
    private UserService userService;

    public DeleteAllUsers() {
        this.userService = ServiceFactory.getInstance().getUserService();
    }


    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        userService.deleteAllUsers();
        return CommandResult.forward(new ShowAllUsers());
    }
}
