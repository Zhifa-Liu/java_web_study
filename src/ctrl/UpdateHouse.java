package ctrl;

import bean.House;
import bean.User;
import dao.HouseDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateHouse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String houseId = request.getParameter("houseId");
        String title = request.getParameter("title");
        String area = request.getParameter("area");
        String price = request.getParameter("price");
        String info = request.getParameter("info");
        String type = request.getParameter("type");

        HouseDao houseDao = HouseDao.getSingletonInstance();
        houseDao.update(new House(Integer.parseInt(houseId),title,Double.parseDouble(area),Double.parseDouble(price),info,Integer.parseInt(type)));
        response.sendRedirect("ListHouses");
    }
}
