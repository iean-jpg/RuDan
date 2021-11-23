package com.liyue.service.category;

import com.liyue.dao.BaseDao;
import com.liyue.dao.category.CategoryDao;
import com.liyue.dao.category.CategoryDaoImpl;
import com.liyue.pojo.category;
import com.sun.corba.se.pept.transport.ConnectionCache;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    private CategoryDao categoryDao;
    public CategoryServiceImpl(){
        categoryDao = new CategoryDaoImpl();
    }
    @Override
    public void addCategory(category category) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            categoryDao.addCat(connection,category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void delCategory(int catId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            categoryDao.delCat(connection,catId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public List<category> getAll() {
        Connection connection = null;
        List<category> categoryList = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            categoryList = categoryDao.getAllCat(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return categoryList;
    }

    @Override
    public category queryCatById(int catId) {
        Connection connection = null;
        category category = null;
        try {
            connection = BaseDao.getConnection();
            category = categoryDao.getCatById(connection,catId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return category;
    }

    @Override
    public category queryCatByName(String catName) {
        Connection connection = null;
        category category = null;
        try {
            connection = BaseDao.getConnection();
            category = categoryDao.getCatByName(connection,catName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return category;
    }

    @Override
    public void updateCategory(category category) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            categoryDao.updateCat(connection,category);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }
}
