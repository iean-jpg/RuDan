package com.liyue.service.user;

import com.liyue.dao.BaseDao;
import com.liyue.dao.user.UserDaoImpl;
import com.liyue.dao.user.userDao;
import com.liyue.pojo.user;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    private userDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }
    @Override
    public user login(String username, String password) {
        Connection connection = null;
        user user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection,username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        if(user.getUserPwd().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public List<user> getAll() {
        Connection connection = null;
        user user = null;
        List<user> userList = new ArrayList<user>();
        try {
            connection = BaseDao.getConnection();
            userList = userDao.getAllUser(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            BaseDao.closeReasource(connection,null,null);
        }
        return userList;
    }

    @Override
    public void registe(String username, String password, String rname, String email, String company, String tel, String fax) {
        Connection connection = null;
        try {
            connection  = BaseDao.getConnection();
            int k = userDao.insertUser(connection,username,password,rname,email,company,tel,fax);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public user queryUser(String username) {
        Connection connection = null;
        user user =null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUserByName(connection,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return user;
    }

    @Override
    public user quertUser(int userId) {
        Connection connection = null;
        user user =null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUserById(connection,userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return user;
    }

    @Override
    public void updateUser(String username, String right, String rname, String email, String company, String tel, String fax, int userId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            int k = userDao.updateUser(connection, username, right, rname, email, company, tel, fax, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection, null, null);
        }
    }

    @Override
    public void updatePwd(user user) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            userDao.updatePwd(connection, user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection, null, null);
        }
    }

    @Override
    public void deleteUser(int userId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            int k = userDao.delUserById(connection, userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void deleteUser(String userName) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            int k = userDao.delUserByName(connection,userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
    }
}
