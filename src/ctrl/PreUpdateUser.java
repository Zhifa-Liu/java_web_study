package ctrl;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PreUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("userid");
        UserDao userDao = UserDao.getSingletonInstance();
        User u = userDao.selectById(id);
        request.setAttribute("user",u);
        request.getRequestDispatcher("userUpdate.jsp").forward(request,response);
    }
}
