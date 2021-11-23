package com.liyue.service.fback;

import com.liyue.dao.BaseDao;
import com.liyue.dao.fback.FbackDao;
import com.liyue.dao.fback.FbackDaoImpl;
import com.liyue.pojo.fback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FbackServiecImpl implements FbackService{
    private FbackDao fbackDao;
    public FbackServiecImpl(){
        fbackDao = new FbackDaoImpl();
    }
    @Override
    public void addFback(fback fback) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            fbackDao.addFback(connection,fback);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public void delFback(int fbackId) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            fbackDao.delFback(connection,fbackId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }

    @Override
    public List<fback> getAllFback() {
        Connection connection = null;
        List<fback> fbacks = new ArrayList<>();
        try {
            connection = BaseDao.getConnection();
            fbacks = fbackDao.getAllFback(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return fbacks;
    }

    @Override
    public fback getFbackById(int fbackId) {
        Connection connection = null;
        fback fback = null;
        try {
            connection = BaseDao.getConnection();
            fback = fbackDao.getFbackById(connection,fbackId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return fback;
    }

    @Override
    public fback getFbackByTitle(String fbackTitle) {
        Connection connection = null;
        fback fback = null;
        try {
            connection = BaseDao.getConnection();
            fback = fbackDao.getFbackByTitle(connection,fbackTitle);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
        return fback;
    }

    @Override
    public void updateFback(fback fback) {
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            fbackDao.updateFback(connection,fback);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeReasource(connection,null,null);
        }
    }
}
