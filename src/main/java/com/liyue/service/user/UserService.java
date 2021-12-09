package com.liyue.service.user;

import com.liyue.pojo.user;

import java.util.List;

public interface UserService {
    user login(String userCode,String password);
    List<user> getAll();
    void registe(String username, String password, String rname, String email, String company, String tel, String fax);
    user queryUser(String username);
    user quertUser(int userId);
    void updateUser(String username, String right, String rname, String email, String company, String tel, String fax, int userId);

    void updatePwd(user user);

    void deleteUser(int userId);
    void deleteUser(String userName);
}
