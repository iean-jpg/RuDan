package com.liyue.pojo;

import java.sql.Date;

public class news {
    private int newsId;
    private String newsTitle;
    private String newsContent;
    private Date newsDateTime;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsDateTime() {
        return newsDateTime;
    }

    public void setNewsDateTime(Date newsDateTime) {
        this.newsDateTime = newsDateTime;
    }
}
