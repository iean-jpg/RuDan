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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/queryUserByName")
public class queryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        user user = userService.queryUser(username);
        List<user> userList = new ArrayList<user>();
        userList.add(user);
        int userCount = userList.size();
        req.getSession().setAttribute("userCount",userCount);
        req.getSession().setAttribute(Constants.USER_SESSION,userList);
        resp.sendRedirect("/user/userlist.jsp");
    }
}
