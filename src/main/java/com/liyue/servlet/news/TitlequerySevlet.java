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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/news/queryNewsByTitle")
public class TitlequerySevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newsTitle = req.getParameter("newstitle");
        NewsService newsService = new NewsServiceImpl();
        news news = newsService.queryNewsByTitle(newsTitle);
        List<news> newsList = new ArrayList<>();
        newsList.add(news);
        int newsCount = newsList.size();
        req.getSession().setAttribute("newsCount",newsCount);
        req.getSession().setAttribute(Constants.NEWS_SESSION,newsList);
        resp.sendRedirect("/admin/newslist.jsp");
    }
}
