package com.liyue.service.news;

import com.liyue.pojo.news;

import java.util.List;

public interface NewsService {
    //获取新闻列表
    List<news> getNewsList();
    //增加新闻
    void addNews(String newsTitle,String newsContent);
    //删除新闻
    void delNews(int newsId);
    //修改新闻
    void updateNews(String newsTitle,String newsContent,int newsId);
    //查询新闻
    news queryNewsById(int newsId);
    news queryNewsByTitle(String newsTitle);
}
