package com.liyue.servlet;

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

@WebServlet(urlPatterns = "/welcome", loadOnStartup = 1)
public class welcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        NewsService newsService = new NewsServiceImpl();
        List<news> newsList = newsService.getNewsList();
        List<product> productList = productService.getAll();
        req.getSession().setAttribute(Constants.PROD_SESSION, productList);
        req.getSession().setAttribute(Constants.NEWS_SESSION, newsList);
        resp.sendRedirect("/index.jsp");
    }
}
