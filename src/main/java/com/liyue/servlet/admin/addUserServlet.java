package com.liyue.servlet.admin;

import com.liyue.service.user.UserService;
import com.liyue.service.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/addUser")
public class addUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rname = req.getParameter("rname");
        String email = req.getParameter("email");
        String company = req.getParameter("company");
        String tel = req.getParameter("tel");
        String fax = req.getParameter("fax");

        UserService userService = new UserServiceImpl();
        userService.registe(username,password,rname,email,company,tel,fax);
        resp.sendRedirect("/admin/getalluser");
    }
}
