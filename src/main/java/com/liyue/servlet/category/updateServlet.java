package com.liyue.servlet.category;

import com.liyue.pojo.category;
import com.liyue.service.category.CategoryService;
import com.liyue.service.category.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/updateCat")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        int catId = Integer.parseInt(req.getParameter("catId"));
        String catName = req.getParameter("catname");
        category category = new category();
        category.setCatId(catId);
        category.setCatName(catName);
        categoryService.updateCategory(category);
        resp.sendRedirect("/category/getAllCat");
    }
}
