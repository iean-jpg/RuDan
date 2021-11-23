package com.liyue.servlet.fback;

import com.liyue.service.fback.FbackService;
import com.liyue.service.fback.FbackServiecImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fback/preAdd")
public class preAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FbackService fbackService = new FbackServiecImpl();
        int userId = Integer.parseInt(req.getParameter("userId"));
        req.getSession().setAttribute("userId",userId);
        resp.sendRedirect("/fback/add.jsp");
    }
}
