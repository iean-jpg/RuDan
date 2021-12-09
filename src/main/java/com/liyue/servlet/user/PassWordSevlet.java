package com.liyue.servlet.user;

import com.liyue.pojo.user;
import com.liyue.service.user.UserService;
import com.liyue.service.user.UserServiceImpl;
import com.liyue.utils.MD5Tool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updatePassword")
public class PassWordSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = MD5Tool.encrypt(req.getParameter("password"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        if (password != null) {
            UserService userService = new UserServiceImpl();
            user user = new user();
            user.setUserPwd(password);
            user.setUserId(userId);
            userService.updatePwd(user);
            resp.sendRedirect("/user/getalluser");
        }
    }
}
