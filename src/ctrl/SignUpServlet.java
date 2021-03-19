package ctrl;

import bean.User;
import service.SignService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    SignService ss = SignService.getSingletonInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        String pswRepeat = req.getParameter("repeatPsw");
        String username = req.getParameter("username");
        String tel = req.getParameter("tel");

        String tips = "";

        if (userid == null || password == null || pswRepeat == null){
            //页面提示
            tips = "请填写完整";
            req.setAttribute("tips",tips);
            req.getRequestDispatcher("signUp.jsp").forward(req,resp);
        } else{
            if (ss.existId(userid)){
                tips = "ID已经被使用，请更换";
                req.setAttribute("tips",tips);
                req.getRequestDispatcher("signUp.jsp").forward(req,resp);
            } else {
                if (!password.equals(pswRepeat)){
                    tips = "两次密码输入不一致";
                    req.setAttribute("tips",tips);
                    req.getRequestDispatcher("signUp.jsp").forward(req,resp);
                } else {
                    User u = new User(userid, password, username, tel);
                    if (ss.signUp(u)) {
                        //提示注册成功并跳转到MyIndex.jsp
                        tips = "注册成功";
                        req.setAttribute("tips",tips);
                        req.setAttribute("user",u);
                        req.getRequestDispatcher("myIndex.jsp").forward(req,resp);
                    }
                }
            }
        }
    }
}
