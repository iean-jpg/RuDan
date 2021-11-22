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

@WebServlet("/news/queryNews")
public class queryNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        NewsService newsService = new NewsServiceImpl();
        news news = newsService.queryNewsById(newsId);
        req.getSession().setAttribute(Constants.NEWS_SESSION,news);
        resp.sendRedirect("/news/detail.jsp");
    }
}
