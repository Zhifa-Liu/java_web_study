package ctrl;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String tel = request.getParameter("tel");

        UserDao userDao = UserDao.getSingletonInstance();
        userDao.update(new User(userid,password,username,tel));
        response.sendRedirect("ListUsers");
    }
}
