package com.liyue.dao.news;

import com.liyue.dao.BaseDao;
import com.liyue.pojo.news;
import com.liyue.pojo.user;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao{

    @Override
    public List<news> getAll(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        news news = null;
        List<news> newsList = new ArrayList<news>();
        if(connection!=null){
            String sql = "select * from news";
            Object[] params = {};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                news = new news();
                news.setNewsId(resultSet.getInt("news_id"));
                news.setNewsTitle(resultSet.getString("news_title"));
                news.setNewsContent(resultSet.getString("news_content"));
                news.setNewsDateTime(resultSet.getDate("news_datetime"));
                newsList.add(news);
            }
            BaseDao.closeReasource(null,preparedStatement,resultSet);
        }
        return newsList;
    }

    @Override
    public int addNews(Connection connection, String newsTitle, String newsContent) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            int k = 0;
            String sql = "insert into news(news_title,news_content,news_datetime) values (?,?,now())";
            Object[] params = {newsTitle,newsContent};
            k = BaseDao.execute(connection,sql,params,preparedStatement);
            return k;
        }
        return 0;
    }

    @Override
    public news getNewsById(Connection connection, int newsId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        news news = null;
        if(connection!=null){
            String sql = "select * from news where news_id = ?";
            Object[] params = {newsId};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                news = new news();
                news.setNewsId(resultSet.getInt("news_id"));
                news.setNewsTitle(resultSet.getString("news_title"));
                news.setNewsContent(resultSet.getString("news_content"));
                news.setNewsDateTime(resultSet.getDate("news_datetime"));
            }
            BaseDao.closeReasource(null,preparedStatement,resultSet);
        }
        return news;
    }

    @Override
    public news getNewsByTitle(Connection connection, String newsTitle) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        news news = null;
        if(connection!=null){
            String sql = "select * from news where news_title = ?";
            Object[] params = {newsTitle};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                news = new news();
                news.setNewsId(resultSet.getInt("news_id"));
                news.setNewsTitle(resultSet.getString("news_title"));
                news.setNewsContent(resultSet.getString("news_content"));
                news.setNewsDateTime(resultSet.getDate("news_datetime"));
            }
            BaseDao.closeReasource(null,preparedStatement,resultSet);
        }
        return news;
    }

    @Override
    public int delNews(Connection connection, int newsId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection != null){
            int k = 0;
            String sql = "delete from news where news_id = ?";
            Object[] params = {newsId};
            k = BaseDao.execute(connection,sql,params,preparedStatement);
            return k;
        }
        return 0;
    }

    @Override
    public int update(Connection connection, String newsTitle, String newsContent,int newsId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            int k =0;
            String sql ="update news set news_title=?,news_content=? where news_id=?";
            Object[] params = {newsTitle,newsContent,newsId};
            k = BaseDao.execute(connection,sql,params,preparedStatement);
            return k;
        }
        return 0;
    }

    @Test
    public void test() throws SQLException {
        Connection connection = BaseDao.getConnection();
        NewsDaoImpl newsDao = new NewsDaoImpl();
        int k = newsDao.addNews(connection,"NoBB","This is a test");
    }
}
