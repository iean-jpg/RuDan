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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product/queryProduct")
public class queryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String prodName = req.getParameter("prodname");
        String prodType = req.getParameter("prodtype");
        List<product> productList = new ArrayList<>();
        product product = productService.getProductByName(prodName,prodType);
        productList.add(product);
        int prodCount = productList.size();
        req.getSession().setAttribute("prodCount",prodCount);
        req.getSession().setAttribute(Constants.PROD_SESSION,productList);
        resp.sendRedirect("/admin/productlist.jsp");
    }
}
