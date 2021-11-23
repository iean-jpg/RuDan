package com.liyue.servlet.product;

import com.liyue.pojo.product;
import com.liyue.service.category.CategoryService;
import com.liyue.service.category.CategoryServiceImpl;
import com.liyue.service.product.ProductService;
import com.liyue.service.product.ProductServiceImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product/getallproduct")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<product> productList = new ArrayList<>();
        productList = productService.getAll();
        int prodCount = productList.size();
        req.getSession().setAttribute("prodCount",prodCount);
        req.getSession().setAttribute(Constants.PROD_SESSION,productList);
        resp.sendRedirect("/admin/productlist.jsp");
    }
}
