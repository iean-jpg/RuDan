package com.liyue.service.product;

import com.liyue.pojo.product;

import java.util.List;

public interface ProductService {
    //增加产品
    void addProduct(product product);
    //删除产品
    void delProduct(int producId);
    //查找产品
    List<product> getAll();
    product getProductById(int prodId);
    product getProductByName(String prodName,String productType);
    //更新产品
    void updateProduct(product product);
}
