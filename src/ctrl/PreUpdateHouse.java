package ctrl;

import bean.House;
import bean.HouseType;
import bean.User;
import dao.HouseDao;
import dao.HouseTypeDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PreUpdateHouse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("houseId");
        HouseDao houseDao = HouseDao.getSingletonInstance();
        House h = houseDao.selectById(Integer.parseInt(id));
        request.setAttribute("house",h);
        HouseTypeDao htd = HouseTypeDao.getSingletonInstance();
        List<HouseType> hts = htd.selectAll();
        request.setAttribute("hts",hts);
        request.getRequestDispatcher("houseUpdate.jsp").forward(request,response);
    }
}
