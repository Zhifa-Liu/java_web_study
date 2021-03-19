package ctrl;

import bean.HouseType;
import dao.HouseTypeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PreAddHouse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HouseTypeDao htd = HouseTypeDao.getSingletonInstance();
        List<HouseType> hts = htd.selectAll();
        request.setAttribute("hts",hts);
        request.getRequestDispatcher("houseAdd.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
