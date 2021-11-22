package com.liyue.dao.news;

import com.liyue.pojo.news;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface NewsDao {
    List<news> getAll(Connection connection) throws SQLException;
    int addNews(Connection connection,String newsTitle,String newsContent) throws SQLException;
    news getNewsById(Connection connection,int newsId) throws SQLException;
    news getNewsByTitle(Connection connection,String newsTitle) throws SQLException;
    int delNews(Connection connection,int newsId) throws SQLException;
    int update(Connection connection,String newsTitle,String newsContent,int newsId) throws SQLException;
}
