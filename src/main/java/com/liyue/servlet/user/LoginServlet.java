package com.liyue.servlet.user;

import com.liyue.pojo.user;
import com.liyue.service.user.UserService;
import com.liyue.service.user.UserServiceImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String imageText = req.getParameter("captcha");
        String text = (String) req.getSession().getAttribute("text");
        UserService userService = new UserServiceImpl();
        user user = userService.login(username,password);
        if (!text.equalsIgnoreCase(imageText)) {
            req.setAttribute("error", "验证码输入错误!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        if(user!=null){
            if(user.getUserRight()==0){
                req.getSession().setAttribute(Constants.USER_SESSION,user);
                resp.sendRedirect("/admin/index.jsp");
            }else {
                req.getSession().setAttribute(Constants.USER_SESSION,user);
                resp.sendRedirect("/user/index.jsp");
            }
        }else {
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
