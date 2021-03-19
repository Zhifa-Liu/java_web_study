package test.sessiontest;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SetSessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        //System.out.println(session.getId());
        session.setAttribute("name","Jack");//String
        session.setAttribute("age",20);//Int
        User u = new User("345","345678","Bob","13213343121");//User-defined
        session.setAttribute("user",u);
        session.setAttribute("name","Bob");//name重复
        session.setAttribute("money",20);//value重复
        //session.removeAttribute("age");
        session.invalidate();
        response.sendRedirect("GetSessionServlet");
    }
}
