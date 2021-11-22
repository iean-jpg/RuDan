package com.liyue.dao.user;

import com.liyue.pojo.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface userDao {
    //得到要登录的用户
    public user getLoginUser(Connection connection,String username) throws SQLException;
    //得到所有用户
    public List<user> getAllUser(Connection connection) throws SQLException;
    //插入用户
    public int insertUser(Connection connection, String username, String password, String rname, String email, String company, String tel, String fax) throws SQLException;
}
