package com.liyue.servlet.news;

import com.liyue.pojo.news;
import com.liyue.service.news.NewsService;
import com.liyue.service.news.NewsServiceImpl;
import com.liyue.utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/news/getallnews")
public class userNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsServiceImpl();
        List<news> newsList = newsService.getNewsList();
        int k = newsList.size();
        req.getSession().setAttribute("newsCount",k);
        req.getSession().setAttribute(Constants.NEWS_SESSION,newsList);
        resp.sendRedirect("/user/newslist.jsp");
    }
}
