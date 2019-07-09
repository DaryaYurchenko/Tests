package controller.filter;

import javax.servlet.FilterConfig;
import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "loginFilter")
public class LoginFilter implements Filter {
    private static final List<String> PAGES_TO_SKIP = new ArrayList<>();
    private static final List<String> COMMANDS_TO_SKIP = new ArrayList<>();

    private static final String CHANGE_LANGUAGE = "CHANGE_LANGUAGE";
    private static final String LOGIN = "LOGIN";
    private static final String REGISTER = "REGISTER";
    private static final String CHANGE_PASSWORD = "CHANGE_PASSWORD";
    private static final String SUBMIT_KEY = "SUBMIT_KEY";
    private static final String SEND_EMAIL_AGAIN = "SEND_EMAIL_AGAIN";
    private static final String LOGOUT = "LOGOUT";

    private static final String LOGIN_PAGE = "login_page";
    private static final String START_PAGE = "start_page";
    private static final String TESTS_TO_PASS_PAGE = "tests_to_pass";
    private static final String REGISTER_PAGE = "register_page";
    private static final String ERROR_PAGE = "error_page";
    private static final String ERROR_404_PAGE = "404_error_page";
    private static final String NOT_SUBMIT_EMAIL_PAGE = "not_submit_email";

    private static final String LOGIN_PAGE_REDIRECT = "jsp/login_page.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        if(isFilter(req, session)) {
            filterChain.doFilter(req, resp);
        }
        else {
            req.getRequestDispatcher(LOGIN_PAGE_REDIRECT).forward(req, resp);
        }
    }

    private boolean isFilter(HttpServletRequest req, HttpSession session) {
        return session.getAttribute("user")!= null || isDoFilterForCommand(req) || isDoFilterForPage(req);
    }

    private boolean isDoFilterForCommand(HttpServletRequest req) {
        String command = req.getParameter("command");
        COMMANDS_TO_SKIP.addAll(Arrays.asList(REGISTER, LOGIN, CHANGE_PASSWORD,
                CHANGE_LANGUAGE, SEND_EMAIL_AGAIN, SUBMIT_KEY, LOGOUT));

        return COMMANDS_TO_SKIP.contains(command);
    }

    private boolean isDoFilterForPage(HttpServletRequest req) {
        String page = req.getParameter("page");
        PAGES_TO_SKIP.addAll(Arrays.asList(NOT_SUBMIT_EMAIL_PAGE, REGISTER_PAGE, LOGIN_PAGE,
                TESTS_TO_PASS_PAGE, START_PAGE, ERROR_PAGE, ERROR_404_PAGE));

        return PAGES_TO_SKIP.contains(page);
    }

    @Override
    public void destroy() {

    }

}
