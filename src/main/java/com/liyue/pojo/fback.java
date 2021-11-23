package com.liyue.pojo;

import java.sql.Date;

public class fback {
    private int fbackId;
    private String fbackTitle;
    private String fbackContent;
    private int userId;
    private Date fbackDateTime;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFbackId() {
        return fbackId;
    }

    public void setFbackId(int fbackId) {
        this.fbackId = fbackId;
    }

    public String getFbackTitle() {
        return fbackTitle;
    }

    public void setFbackTitle(String fbackTitle) {
        this.fbackTitle = fbackTitle;
    }

    public String getFbackContent() {
        return fbackContent;
    }

    public void setFbackContent(String fbackContent) {
        this.fbackContent = fbackContent;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getFbackDateTime() {
        return fbackDateTime;
    }

    public void setFbackDateTime(Date fbackDateTime) {
        this.fbackDateTime = fbackDateTime;
    }
}
