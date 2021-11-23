package com.liyue.servlet.category;

import com.liyue.service.category.CategoryService;
import com.liyue.service.category.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/delCategory")
public class delServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        int catId = Integer.parseInt(req.getParameter("catId"));
        categoryService.delCategory(catId);
        resp.sendRedirect("/category/getAllCat");
    }
}
