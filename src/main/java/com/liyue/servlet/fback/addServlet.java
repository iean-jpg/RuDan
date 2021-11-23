package com.liyue.servlet.fback;

import com.liyue.pojo.fback;
import com.liyue.service.fback.FbackService;
import com.liyue.service.fback.FbackServiecImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fback/addFback")
public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FbackService fbackService = new FbackServiecImpl();
        fback fback = new fback();
        String fbackTitle = req.getParameter("fbacktitle");
        String fbackContent = req.getParameter("fbackcontent");
        int userId = Integer.parseInt(req.getParameter("userId"));
        fback.setUserId(userId);
        fback.setFbackTitle(fbackTitle);
        fback.setFbackContent(fbackContent);
        fbackService.addFback(fback);
        resp.sendRedirect("/user/fback/getallfback");
    }
}
