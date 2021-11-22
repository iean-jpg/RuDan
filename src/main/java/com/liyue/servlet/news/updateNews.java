package com.liyue.servlet.news;

import com.liyue.service.news.NewsService;
import com.liyue.service.news.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news/updateNews")
public class updateNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newsTitle = req.getParameter("newstitle");
        String newsContent = req.getParameter("newscontent");
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        NewsService newsService = new NewsServiceImpl();
        newsService.updateNews(newsTitle,newsContent,newsId);
        resp.sendRedirect("/news/getallnews");
    }
}
