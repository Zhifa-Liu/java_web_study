package ctrl;

import bean.House;
import bean.HouseType;
import dao.HouseDao;
import dao.HouseTypeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LookupHouse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = request.getParameter("houseId");
        HouseDao houseDao = HouseDao.getSingletonInstance();
        House h = houseDao.selectById(Integer.parseInt(houseId));
        request.setAttribute("house",h);
        HouseTypeDao houseTypeDao = HouseTypeDao.getSingletonInstance();
        request.setAttribute("hts",(List<HouseType>)houseTypeDao.selectAll());
        request.getRequestDispatcher("houseLookup.jsp").forward(request,response);
    }
}
