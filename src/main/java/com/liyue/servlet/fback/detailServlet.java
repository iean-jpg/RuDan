package com.liyue.servlet.fback;

import com.liyue.pojo.fback;
import com.liyue.service.fback.FbackService;
import com.liyue.service.fback.FbackServiecImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fback/showDetail")
public class detailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FbackService fbackService = new FbackServiecImpl();
        int fbackId = Integer.parseInt(req.getParameter("fbackId"));
        fback fback = fbackService.getFbackById(fbackId);
        req.getSession().setAttribute(Constants.FBACK_SESSION,fback);
        resp.sendRedirect("/fback/detail.jsp");
    }
}
