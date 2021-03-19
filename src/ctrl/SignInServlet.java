package ctrl;

import bean.User;
import service.SignService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    SignService ss = SignService.getSingletonInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signUp.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String userid=req.getParameter("userid");
        String password=req.getParameter("password");

        HttpSession session = req.getSession();

        String tips = "";
        User u = ss.signIn(userid);
        if (u != null && u.getPassword().equals(password)){
            session.setAttribute("user",u);
            resp.sendRedirect("myIndex.jsp");
        } else{
            req.setAttribute("tips",tips);
            req.getRequestDispatcher("signIn.jsp").forward(req, resp);
        }
    }
}
