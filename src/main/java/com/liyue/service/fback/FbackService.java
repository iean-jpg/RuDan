package com.liyue.service.fback;

import com.liyue.pojo.fback;

import java.util.List;

public interface FbackService {
    //添加反馈
    void addFback(fback fback);
    //删除反馈
    void delFback(int fbackId);
    //查找反馈
    List<fback> getAllFback();
    fback getFbackById(int fbackId);
    fback getFbackByTitle(String fbackTitle);
    //更新反馈
    void updateFback(fback fback);
}
