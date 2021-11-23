package com.liyue.pojo;

import java.sql.Date;

public class product {
    private int prodId;
    private int catId;
    private String prodName;
    private String prodType;
    private float prodPrice;
    private String prodImage;
    private String prodText;
    private Date prodDateTime;
    private int prodFirstShow;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public float getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(float prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }

    public String getProdText() {
        return prodText;
    }

    public void setProdText(String prodText) {
        this.prodText = prodText;
    }

    public Date getProdDateTime() {
        return prodDateTime;
    }

    public void setProdDateTime(Date prodDateTime) {
        this.prodDateTime = prodDateTime;
    }

    public int getProdFirstShow() {
        return prodFirstShow;
    }

    public void setProdFirstShow(int prodFirstShow) {
        this.prodFirstShow = prodFirstShow;
    }
}
