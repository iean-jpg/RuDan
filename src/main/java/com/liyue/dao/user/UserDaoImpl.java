package com.liyue.dao.user;

import com.liyue.dao.BaseDao;
import com.liyue.pojo.user;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements userDao{
    @Override
    public user getLoginUser(Connection connection, String username) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = null;
        if(connection!=null){
            String sql = "select * from user where user_name = ?";
            Object[] params = {username};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            if(resultSet.next()){
                user = new user();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserRname(resultSet.getString("user_rname"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserCompany(resultSet.getString("user_company"));
                user.setUserTel(resultSet.getString("user_tel"));
                user.setUserFax(resultSet.getString("user_fax"));
                user.setUserDateTime(resultSet.getDate("user_datetime"));
                user.setUserRight(resultSet.getInt("user_right"));
            }
            BaseDao.closeReasource(null,preparedStatement,resultSet);
        }
        return user;
    }

    @Override
    public List<user> getAllUser(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        user user = null;
        List<user> userList = new ArrayList<user>();
        if(connection!=null){
            String sql = "select * from user";
            Object[] params = {};
            resultSet = BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            while (resultSet.next()){
                user = new user();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setUserRname(resultSet.getString("user_rname"));
                user.setUserPwd(resultSet.getString("user_pwd"));
                user.setUserEmail(resultSet.getString("user_email"));
                user.setUserCompany(resultSet.getString("user_company"));
                user.setUserTel(resultSet.getString("user_tel"));
                user.setUserFax(resultSet.getString("user_fax"));
                user.setUserDateTime(resultSet.getDate("user_datetime"));
                user.setUserRight(resultSet.getInt("user_right"));
                userList.add(user);
            }
            BaseDao.closeReasource(null,preparedStatement,resultSet);
        }
        return userList;
    }

    @Override
    public int insertUser(Connection connection, String username, String password, String rname, String email, String company, String tel, String fax) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            int k = 0;
            String sql = "insert into user(user_name,user_rname,user_pwd,user_email,user_company,user_tel,user_fax,user_datetime) values (?,?,?,?,?,?,?,now())";
            Object[] params = {username,rname,password,email,company,tel,fax};
            k = BaseDao.execute(connection,sql,params,preparedStatement);
            return k;
        }
        return 0;
    }

    @Test
    public void test() throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        Connection connection = BaseDao.getConnection();
        List<user> user = userDao.getAllUser(connection);
        for(int i=0;i<user.size();i++){
            System.out.println(user.get(i).getUserName());
        }
    }
}
