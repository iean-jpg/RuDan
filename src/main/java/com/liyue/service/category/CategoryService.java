package com.liyue.service.category;

import com.liyue.pojo.category;

import java.util.List;

public interface CategoryService {
    //添加分类
    void addCategory(category category);
    //删除分类
    void delCategory(int catId);
    //查询分类
    List<category> getAll();
    category queryCatById(int catId);
    category queryCatByName(String catName);
    //更新分类
    void updateCategory(category category);
}
