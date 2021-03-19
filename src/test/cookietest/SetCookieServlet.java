package test.cookietest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c_1 = new Cookie("ID","123");
        c_1.setMaxAge(60);
        Cookie psw = new Cookie("Tel","123456789");
        psw.setMaxAge(20);
        Cookie c_2 = new Cookie("ID","456");
        c_2.setMaxAge(30);
        Cookie card = new Cookie("Card","123456789");
        card.setMaxAge(20);

        response.addCookie(c_1);
        response.addCookie(c_2);
        response.addCookie(psw);
        response.addCookie(card);

        response.sendRedirect("GetCookieServlet");
    }
}
