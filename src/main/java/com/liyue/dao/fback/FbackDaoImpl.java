package com.liyue.dao.fback;

import com.liyue.dao.BaseDao;
import com.liyue.pojo.fback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FbackDaoImpl implements FbackDao{
    @Override
    public void addFback(Connection connection, fback fback) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "insert into fback(fback_title,fback_content,user_id,fback_datatime) values (?,?,?,now())";
            Object[] params = {fback.getFbackTitle(),fback.getFbackContent(),fback.getUserId()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public void delFback(Connection connection, int fbackId) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "delete from fback where fback_id=?";
            Object[] params = {fbackId};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }

    @Override
    public List<fback> getAllFback(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        fback fback =  null;
        List<fback> fbacks = new ArrayList<>();
        if(connection!=null){
            String sql ="select a.user_name,b.* from user a,fback b where a.user_id=b.user_id";
            Object[] params = {};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                fback = new fback();
                fback.setUserName(resultSet.getString("user_name"));
                fback.setFbackId(resultSet.getInt("fback_id"));
                fback.setFbackTitle(resultSet.getString("fback_title"));
                fback.setFbackContent(resultSet.getString("fback_content"));
                fback.setUserId(resultSet.getInt("user_id"));
                fback.setFbackDateTime(resultSet.getDate("fback_datatime"));
                fbacks.add(fback);
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return fbacks;
    }

    @Override
    public fback getFbackById(Connection connection, int fbackId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        fback fback =  null;
        if(connection!=null){
            String sql ="select a.user_name,b.* from user a,fback b where a.user_id=b.user_id and b.fback_id=?";
            Object[] params = {fbackId};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                fback = new fback();
                fback.setUserName(resultSet.getString("user_name"));
                fback.setFbackId(resultSet.getInt("fback_id"));
                fback.setFbackTitle(resultSet.getString("fback_title"));
                fback.setFbackContent(resultSet.getString("fback_content"));
                fback.setUserId(resultSet.getInt("user_id"));
                fback.setFbackDateTime(resultSet.getDate("fback_datatime"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return fback;
    }

    @Override
    public fback getFbackByTitle(Connection connection, String fbackTitle) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        fback fback =  null;
        if(connection!=null){
            String sql ="select a.user_name,b.* from user a,fback b where a.user_id=b.user_id and b.fback_title=?";
            Object[] params = {fbackTitle};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                fback = new fback();
                fback.setUserName(resultSet.getString("user_name"));
                fback.setFbackId(resultSet.getInt("fback_id"));
                fback.setFbackTitle(resultSet.getString("fback_title"));
                fback.setFbackContent(resultSet.getString("fback_content"));
                fback.setUserId(resultSet.getInt("user_id"));
                fback.setFbackDateTime(resultSet.getDate("fback_datatime"));
            }
            BaseDao.closeReasource(connection,preparedStatement,resultSet);
        }
        return fback;
    }

    @Override
    public void updateFback(Connection connection, fback fback) throws SQLException {
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "update fback set fback_title=?,fback_content=? where fback_id=?";
            Object[] params = {fback.getFbackTitle(),fback.getFbackContent(),fback.getFbackId()};
            BaseDao.execute(connection,sql,params,preparedStatement);
        }
    }
}
