package ctrl;

import bean.House;
import dao.HouseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HousesPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page==null||page.equals("")) {
            page="1";
        }
        int size = 2;
        HouseDao houseDao = HouseDao.getSingletonInstance();
        int count = houseDao.getCount();
        int total = count/size;
        if (count%size != 0) {
            total++;
        }
        List<House> houses = houseDao.selectUsersByPage(Integer.parseInt(page),size);
        request.setAttribute("houses",houses);
        request.setAttribute("curPage",page);
        request.setAttribute("totalPage",total);
        request.getRequestDispatcher("houses.jsp").forward(request, response);
    }
}
