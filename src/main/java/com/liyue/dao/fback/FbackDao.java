package com.liyue.dao.fback;

import com.liyue.pojo.fback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface FbackDao {
    //增加反馈
    void addFback(Connection connection, fback fback) throws SQLException;
    //删除反馈
    void delFback(Connection connection,int fbackId) throws SQLException;
    //查找反馈
    List<fback> getAllFback(Connection connection) throws SQLException;
    fback getFbackById(Connection connection,int fbackId) throws SQLException;
    fback getFbackByTitle(Connection connection,String fbackTitle) throws SQLException;
    //更新反馈
    void updateFback(Connection connection,fback fback) throws SQLException;
}
