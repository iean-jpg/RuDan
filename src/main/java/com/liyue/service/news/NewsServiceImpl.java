package com.liyue.service.news;

import com.liyue.dao.BaseDao;
import com.liyue.dao.news.NewsDao;
import com.liyue.dao.news.NewsDaoImpl;
import com.liyue.dao.user.UserDaoImpl;
import com.liyue.dao.user.userDao;
import com.liyue.pojo.news;
import com.liyue.pojo.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService{
    private NewsDao newsDao;
    public NewsServiceImpl(){
        newsDao = new NewsDaoImpl();
    }
    @Override
    public List<news> getNewsList() {
        Connection connection = null;
        news news = null;
        List<news> newsList = new ArrayList<news>();
        try {
            connection = BaseDao.getConnection();
            newsList = newsDao.getAll(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            BaseDao.closeReasource(connection,null,null);
        }
        return newsList;
    }

    @Override
    public void addNews(String newsTitle, String newsContent) {
        Connection connection = null;
        try {
            connection  = BaseDao.getConnection();
            int k = newsDao.addNews(connection,newsTitle,newsContent);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void delNews(int newsId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            int k = newsDao.delNews(connection,newsId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void updateNews(String newsTitle, String newsContent, int newsId) {
        Connection connection = null;
        try {
            connection  = BaseDao.getConnection();
            int k = newsDao.update(connection,newsTitle,newsContent,newsId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public news queryNewsById(int newsId) {
        Connection connection = null;
        news news = null;
        try {
            connection = BaseDao.getConnection();
            news = newsDao.getNewsById(connection,newsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return news;
    }

    @Override
    public news queryNewsByTitle(String newsTitle) {
        Connection connection = null;
        news news = null;
        try {
            connection = BaseDao.getConnection();
            news = newsDao.getNewsByTitle(connection,newsTitle);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return news;
    }
}
