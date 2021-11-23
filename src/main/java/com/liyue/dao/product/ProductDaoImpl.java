package com.liyue.dao.product;

import com.liyue.dao.BaseDao;
import com.liyue.pojo.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{
    @Override
    public void addProduct(Connection connection, product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "insert into product(cat_id,prod_name,prod_type,prod_price,prod_image,prod_desc,prod_datetime,prod_firstshow) values (?,?,?,?,?,?,now(),?)";
            Object[] params = {product.getCatId(),product.getProdName(),product.getProdType(),product.getProdPrice(),product.getProdImage(),product.getProdText(),product.getProdFirstShow()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public void delProduct(Connection connection, int productId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "delete from product where prod_id = ?";
            Object[] params = {productId};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public List<product> getAllProduct(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ResultSet resultSet1 = null;
        product product = null;
        List<product> productList= new ArrayList<>();
        if(connection!=null){
            String sql = "select a.cat_name,b.* from category a,product b where a.cat_id=b.cat_id";
            Object[] params = {};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                product = new product();
                product.setCategory(resultSet.getString("cat_name"));
                product.setProdId(resultSet.getInt("prod_id"));
                product.setCatId(resultSet.getInt("cat_id"));
                product.setProdName(resultSet.getString("prod_name"));
                product.setProdType(resultSet.getString("prod_type"));
                product.setProdPrice(resultSet.getFloat("prod_price"));
                product.setProdImage(resultSet.getString("prod_image"));
                product.setProdText(resultSet.getString("prod_desc"));
                product.setProdDateTime(resultSet.getDate("prod_datetime"));
                product.setProdFirstShow(resultSet.getInt("prod_firstshow"));
                productList.add(product);
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return productList;
    }

    @Override
    public product getProductById(Connection connection, int productId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        product product = null;
        if(connection!=null){
            String sql = "select a.cat_name,b.* from category a,product b where a.cat_id=b.cat_id and b.prod_id=?";
            Object[] params = {productId};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                product = new product();
                product.setCategory(resultSet.getString("cat_name"));
                product.setProdId(resultSet.getInt("prod_id"));
                product.setCatId(resultSet.getInt("cat_id"));
                product.setProdName(resultSet.getString("prod_name"));
                product.setProdType(resultSet.getString("prod_type"));
                product.setProdPrice(resultSet.getFloat("prod_price"));
                product.setProdImage(resultSet.getString("prod_image"));
                product.setProdText(resultSet.getString("prod_desc"));
                product.setProdDateTime(resultSet.getDate("prod_datetime"));
                product.setProdFirstShow(resultSet.getInt("prod_firstshow"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return product;
    }

    @Override
    public product getProductByName(Connection connection, String productName,String productType) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        product product = null;
        if(connection!=null){
            String sql = "select a.cat_name,b.* from category a,product b where a.cat_id=b.cat_id and b.prod_name=? and b.prod_type=?";
            Object[] params = {productName,productType};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                product = new product();
                product.setCategory(resultSet.getString("cat_name"));
                product.setProdId(resultSet.getInt("prod_id"));
                product.setCatId(resultSet.getInt("cat_id"));
                product.setProdName(resultSet.getString("prod_name"));
                product.setProdType(resultSet.getString("prod_type"));
                product.setProdPrice(resultSet.getFloat("prod_price"));
                product.setProdImage(resultSet.getString("prod_image"));
                product.setProdText(resultSet.getString("prod_desc"));
                product.setProdDateTime(resultSet.getDate("prod_datetime"));
                product.setProdFirstShow(resultSet.getInt("prod_firstshow"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return product;
    }

    @Override
    public void updateProduct(Connection connection, product product) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "update product set cat_id=?,prod_name=?,prod_type=?,prod_price=?,prod_image=?,prod_desc=?,prod_firstshow=? where prod_id=?";
            Object[] params = {product.getCatId(),product.getProdName(),product.getProdType(),product.getProdPrice(),product.getProdImage(),product.getProdText(),product.getProdFirstShow(),product.getProdId()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }
}
