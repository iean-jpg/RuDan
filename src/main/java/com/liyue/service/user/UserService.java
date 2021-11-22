package com.liyue.service.user;

import com.liyue.pojo.user;

import java.util.List;

public interface UserService {
    public user login(String userCode,String password);
    public List<user> getAll();
    public void registe(String username, String password, String rname, String email, String company, String tel, String fax);
}
