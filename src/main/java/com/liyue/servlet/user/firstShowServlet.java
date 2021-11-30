package com.liyue.servlet.user;

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
import java.util.List;

@WebServlet("/user/welcome")
public class firstShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<product> productList =  productService.getAll();
        req.getSession().setAttribute(Constants.PROD_SESSION,productList);
        resp.sendRedirect("/user/welcome.jsp");
    }
}
