package com.liyue.servlet.category;

import com.liyue.pojo.category;
import com.liyue.service.category.CategoryService;
import com.liyue.service.category.CategoryServiceImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/category/queryCat")
public class queryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        category category = null;
        int catId = Integer.parseInt(req.getParameter("catId"));
        category = categoryService.queryCatById(catId);
        req.getSession().setAttribute(Constants.CAT_SESSION,category);
        resp.sendRedirect("/category/edit.jsp");
    }
}
