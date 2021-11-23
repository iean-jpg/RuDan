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
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/category/getAllCat")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        List<category> categoryList = new ArrayList<>();
        categoryList = categoryService.getAll();
        int k = categoryList.size();
        req.getSession().setAttribute("catCount",k);
        req.getSession().setAttribute(Constants.CAT_SESSION,categoryList);
        resp.sendRedirect("/admin/categorylist.jsp");
    }
}
