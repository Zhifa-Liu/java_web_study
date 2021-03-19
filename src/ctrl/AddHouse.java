package ctrl;

import bean.House;
import dao.HouseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 32098
 */
public class AddHouse extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title");
        String area = request.getParameter("area");
        String price = request.getParameter("price");
        String info = request.getParameter("info");
        String typeId = request.getParameter("type");
        House h = new House(0,title,Double.parseDouble(area),Double.parseDouble(price),info,Integer.parseInt(typeId));
        HouseDao houseDao = HouseDao.getSingletonInstance();
        houseDao.insertHouse(h);
        response.sendRedirect("ListHouses");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
