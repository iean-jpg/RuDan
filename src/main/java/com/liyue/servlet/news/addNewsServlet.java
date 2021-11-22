package com.liyue.servlet.news;

import com.liyue.service.news.NewsService;
import com.liyue.service.news.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/news/addNews")
public class addNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newsTitle = req.getParameter("newstitle");
        String newsContent = req.getParameter("newscontent");
        NewsService newsService = new NewsServiceImpl();
        newsService.addNews(newsTitle,newsContent);
        resp.sendRedirect("/admin/newslist.jsp");
    }
}
