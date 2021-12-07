package com.liyue.servlet.user;

import com.liyue.service.user.UserService;
import com.liyue.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.spi.SyncResolver;
import java.io.IOException;

@WebServlet("/user/editUser")
public class editServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String right = req.getParameter("right");
        String rname = req.getParameter("rname");
        String email = req.getParameter("email");
        String company = req.getParameter("company");
        String tel = req.getParameter("tel");
        String fax = req.getParameter("fax");
        int userId = Integer.parseInt(req.getParameter("userId"));
        UserService userService = new UserServiceImpl();
        userService.updateUser(username,right,rname,email,company,tel,fax,userId);
        resp.sendRedirect("/user/getalluser");
    }
}
