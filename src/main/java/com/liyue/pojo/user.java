package com.liyue.pojo;

import java.sql.Date;

public class user {
    private int userId;
    private String userName;
    private String userRname;
    private String userPwd;
    private String userEmail;
    private String userCompany;
    private String userTel;
    private String userFax;
    private Date userDateTime;
    private int userRight;

    public String getUserRname() {
        return userRname;
    }

    public void setUserRname(String userRname) {
        this.userRname = userRname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserFax() {
        return userFax;
    }

    public void setUserFax(String userFax) {
        this.userFax = userFax;
    }

    public Date getUserDateTime() {
        return userDateTime;
    }

    public void setUserDateTime(Date userDateTime) {
        this.userDateTime = userDateTime;
    }

    public int getUserRight() {
        return userRight;
    }

    public void setUserRight(int userRight) {
        this.userRight = userRight;
    }
}
