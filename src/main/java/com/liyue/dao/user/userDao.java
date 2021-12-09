package com.liyue.dao.user;

import com.liyue.pojo.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface userDao {
    //得到要登录的用户
    user getLoginUser(Connection connection,String username) throws SQLException;
    //得到所有用户
    List<user> getAllUser(Connection connection) throws SQLException;
    //插入用户
    int insertUser(Connection connection, String username, String password, String rname, String email, String company, String tel, String fax) throws SQLException;
    //查找用户
    user getUserById(Connection connection,int userId) throws SQLException;
    user getUserByName(Connection connection,String username) throws SQLException;
    //更新用户
    int updateUser(Connection connection, String username, String right, String rname, String email, String company, String tel, String fax, int userId) throws SQLException;

    int updatePwd(Connection connection, user user) throws SQLException;

    //删除用户
    int delUserById(Connection connection, int userId) throws SQLException;
    int delUserByName(Connection connection,String userName) throws SQLException;
}

