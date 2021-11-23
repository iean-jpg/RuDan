package com.liyue.servlet.product;

import com.liyue.pojo.product;
import com.liyue.service.product.ProductService;
import com.liyue.service.product.ProductServiceImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/showdetail")
public class detailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        int prodId = Integer.parseInt(req.getParameter("prodId"));
        product product = productService.getProductById(prodId);
        req.getSession().setAttribute(Constants.PROD_SESSION,product);
        resp.sendRedirect("/product/details.jsp");
    }
}
