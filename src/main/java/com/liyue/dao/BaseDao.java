package com.liyue.dao;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;


    //初始化获取对应资源
    static {
        Properties properties = new Properties();
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    //获取数据库链接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //查询公共方法
    public static ResultSet execute(Connection connection,PreparedStatement ps,ResultSet rs,String sql,Object[] params) throws SQLException {
        ps = connection.prepareStatement(sql);
        for (int i=0;i<params.length;i++){
            ps.setObject(i+1,params[i]);
        }
        rs = ps.executeQuery();
        return rs;
    }

    //增删改公共方法
    public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        for (int i=0;i<params.length;i++){
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRows = preparedStatement.executeUpdate();
        return updateRows;
    }

    //释放资源
    public static boolean closeReasource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;

        if (resultSet!=null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }

        if (preparedStatement!=null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if (connection!=null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;
    }

    @Test
    public void test(){
        Connection connection = getConnection();
        System.out.println(connection);
    }
}
