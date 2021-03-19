package test.cookietest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c: cookies){
                out.println("Name:"+c.getName()+"; Value:"+c.getValue());
            }
        }

    }
}
