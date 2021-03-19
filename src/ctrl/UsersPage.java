package ctrl;

import bean.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page==null||page.equals("")) {
            page="1";
        }
        int size = 3;
        UserDao userDao = UserDao.getSingletonInstance();
        int count = userDao.getCount();
        int total = count/size;
        if (count%size != 0) {
            total++;
        }
        List<User> users = userDao.selectUsersByPage(Integer.parseInt(page),size);
        request.setAttribute("users",users);
        request.setAttribute("curPage",page);
        request.setAttribute("totalPage",total);
        request.getRequestDispatcher("users.jsp").forward(request, response);
    }
}
