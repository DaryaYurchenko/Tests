package controller.command;

import controller.pages.Pages;
import model.entity.Question;
import model.service.impl.QuestionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

public class StartTest extends Command implements Pages {
    private QuestionService questionService;

    public StartTest() {
        this.questionService = new QuestionService();
    }

    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {
        String themeId = req.getParameter("theme_id");
        List<Question> questions = questionService.findQuestionsByTheme(Long.parseLong(themeId));
        Collections.shuffle(questions);

        req.getSession().setAttribute("questions", questions);

        int counter = Integer.parseInt(req.getParameter("counter"));
        req.getSession().setAttribute("counter", counter);

        return CommandResult.forward(new PassTest());
    }
}
