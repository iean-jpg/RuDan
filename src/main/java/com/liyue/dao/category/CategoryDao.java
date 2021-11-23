package com.liyue.dao.category;

import com.liyue.pojo.category;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    //添加分类
    void addCat(Connection connection, category category) throws SQLException;
    //删除分类
    void delCat(Connection connection, int catId) throws SQLException;
    //查找分类
    List<category> getAllCat(Connection connection) throws SQLException;
    category getCatById(Connection connection,int catId) throws SQLException;
    category getCatByName(Connection connection,String catName) throws SQLException;
    //更改分类
    void updateCat(Connection connection,category category) throws SQLException;
}
