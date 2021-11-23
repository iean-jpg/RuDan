package com.liyue.service.product;

import com.liyue.dao.BaseDao;
import com.liyue.dao.product.ProductDao;
import com.liyue.dao.product.ProductDaoImpl;
import com.liyue.pojo.product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;
    public ProductServiceImpl(){
        productDao = new ProductDaoImpl();
    }
    @Override
    public void addProduct(product product) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            productDao.addProduct(connection,product);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void delProduct(int producId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            productDao.delProduct(connection,producId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public List<product> getAll() {
        Connection connection = null;
        List<product> productList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            productList = productDao.getAllProduct(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return productList;
    }

    @Override
    public product getProductById(int prodId) {
        Connection connection = null;
        product product = null;
        try {
            connection = BaseDao.getConnection();
            product = productDao.getProductById(connection,prodId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return product;
    }

    @Override
    public product getProductByName(String prodName,String productType) {
        Connection connection = null;
        product product = null;
        try {
            connection = BaseDao.getConnection();
            product = productDao.getProductByName(connection,prodName,productType);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return product;
    }

    @Override
    public void updateProduct(product product) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            productDao.updateProduct(connection,product);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }
}
