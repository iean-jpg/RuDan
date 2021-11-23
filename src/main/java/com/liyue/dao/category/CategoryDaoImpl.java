package com.liyue.dao.category;

import com.liyue.dao.BaseDao;
import com.liyue.pojo.category;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao{

    @Override
    public void addCat(Connection connection, category category) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "insert into category(cat_name) values(?)";
            Object[] params = {category.getCatName()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public void delCat(Connection connection, int catId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "delete from category where cat_id=?";
            Object[] params = {catId};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public List<category> getAllCat(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        category category = null;
        List<category> categoryList = new ArrayList<>();
        if(connection!=null){
            String sql = "select * from category";
            Object[] params = {};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                category = new category();
                category.setCatId(resultSet.getInt("cat_id"));
                category.setCatName(resultSet.getString("cat_name"));
                categoryList.add(category);
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return categoryList;
    }

    @Override
    public category getCatById(Connection connection, int catId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        category category = null;
        if(connection!=null){
            String sql = "select * from category where cat_id = ?";
            Object[] params = {catId};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                category = new category();
                category.setCatId(resultSet.getInt("cat_id"));
                category.setCatName(resultSet.getString("cat_name"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return category;
    }

    @Override
    public category getCatByName(Connection connection, String catName) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        category category = null;
        if(connection!=null){
            String sql = "select * from category where cat_name = ?";
            Object[] params = {catName};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                category = new category();
                category.setCatId(resultSet.getInt("cat_id"));
                category.setCatName(resultSet.getString("cat_name"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return category;
    }

    @Override
    public void updateCat(Connection connection, category category) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            String sql = "update category set cat_name=? where cat_id=?";
            Object[] params = {category.getCatName(),category.getCatId()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Test
    public void test(){
        Connection connection = BaseDao.getConnection();
        CategoryDao categoryDao = new CategoryDaoImpl();
        try {
            List<category> categoryList =  categoryDao.getAllCat(connection);
            System.out.println(categoryList.get(0).getCatName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
