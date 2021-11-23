package com.liyue.dao.product;

import com.liyue.pojo.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    //增加产品
    void addProduct(Connection connection, product product) throws SQLException;
    //删除产品
    void delProduct(Connection connection, int productId) throws SQLException;
    //查找产品
    List<product> getAllProduct(Connection connection) throws SQLException;
    product getProductById(Connection connection,int productId) throws SQLException;
    product getProductByName(Connection connection,String productName,String productType) throws SQLException;
    //更新产品
    void updateProduct(Connection connection,product product) throws SQLException;
}
