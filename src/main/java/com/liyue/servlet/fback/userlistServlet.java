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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/fback/getallfback")
public class userlistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FbackService fbackService = new FbackServiecImpl();
        List<fback> fbacks = new ArrayList<>();
        fbacks = fbackService.getAllFback();
        int fbackCount = fbacks.size();
        req.getSession().setAttribute("fbackCount",fbackCount);
        req.getSession().setAttribute(Constants.FBACK_SESSION,fbacks);
        resp.sendRedirect("/user/fbacklist.jsp");
    }
}
