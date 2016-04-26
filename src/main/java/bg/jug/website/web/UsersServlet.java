package bg.jug.website.web;

import bg.jug.website.model.user.User;
import bg.jug.website.user.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ivan St. Ivanov
 */
@WebServlet(urlPatterns = "/Users")
public class UsersServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("fullName");
        userService.addUser(new User(userName, userName + "@example.com", userName));
        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            resp.getWriter().println(user.getFullname());
        }
    }
}
