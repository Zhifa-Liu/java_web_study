package test.sessiontest;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class GetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;utf-8");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");//name(key)重复会被覆盖
        Integer age = (Integer) session.getAttribute("age");
        User u = (User) session.getAttribute("user");
        Integer money = (Integer) session.getAttribute("money");
        PrintWriter out = response.getWriter();
        out.println("Name: "+name+"</br>Age: "+age+"</br>Money: "+money);
        out.println("</br>User Info: </br>"+u.getUsername()+" "+u.getTel());
    }
}
