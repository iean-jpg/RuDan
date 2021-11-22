package com.liyue.servlet.user;

import com.liyue.pojo.user;
import com.liyue.service.user.UserService;
import com.liyue.service.user.UserServiceImpl;
import com.liyue.utils.Constants;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/getalluser")
public class userServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<user> userList = userService.getAll();
        int k = userList.size();
        req.getSession().setAttribute("userCount",k);
        req.getSession().setAttribute(Constants.USER_SESSION,userList);
        resp.sendRedirect("/user/userlist.jsp");
    }
}
