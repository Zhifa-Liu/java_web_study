package test.paramouttest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamOutServlet extends HttpServlet {
    public ParamOutServlet(){
        System.out.println("ParamOutServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取初始化参数
        System.out.println("Initial: "+getInitParameter("param"));//getServletConfig().getInitParameter("param");
        //获取上下文参数
        //先获取上下文对象 再获取上下文参数
        System.out.println("Context: "+getServletContext().getInitParameter("parameter"));
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String u=req.getParameter("username");
        String psw=req.getParameter("psw");
        String gender=req.getParameter("gender");
        String[] hobbits=req.getParameterValues("hobbit");
        PrintWriter out=resp.getWriter();
        out.println("<p>Welcome"+u+", your information is:</p></br>");
        out.println("Password:"+psw+"</br>");
        out.println("Gender:"+gender+"</br>");
        StringBuilder str= new StringBuilder();
        for (String h: hobbits){
            str.append(h).append(" ");
        }
        out.println("Hobbits:"+str+"</br>");
    }
}
