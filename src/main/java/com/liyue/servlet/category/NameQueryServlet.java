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

@WebServlet("/category/queryCatByName")
public class NameQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        String catName = req.getParameter("catname");
        List<category> categoryList = new ArrayList<>();
        category category = categoryService.queryCatByName(catName);
        categoryList.add(category);
        int catCount = categoryList.size();
        req.getSession().setAttribute("catCount",catCount);
        req.getSession().setAttribute(Constants.CAT_SESSION,category);
        resp.sendRedirect("/category/getAllCat");
    }
}
