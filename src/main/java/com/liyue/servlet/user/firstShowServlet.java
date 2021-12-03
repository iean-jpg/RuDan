package com.liyue.servlet.user;

import com.liyue.pojo.news;
import com.liyue.pojo.product;
import com.liyue.service.news.NewsService;
import com.liyue.service.news.NewsServiceImpl;
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
        NewsService newsService = new NewsServiceImpl();
        List<product> productList =  productService.getAll();
        List<news> newsList = newsService.getNewsList();
        req.getSession().setAttribute(Constants.PROD_SESSION,productList);
        req.getSession().setAttribute(Constants.NEWS_SESSION,newsList);
        resp.sendRedirect("/user/welcome.jsp");
    }
}
