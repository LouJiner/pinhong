package com.zryx.company.service;

import com.zryx.company.common.config.PageConfig;
import com.zryx.company.model.Users;

import java.util.List;

public interface UsersService {

    /**
     * 查看所有用户
     * @return
     */
    List<Users> getAllUsers();

    void delUsers(int id);

    void addUsers(Users users);

    /**
     * 等陆验证
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    int loginInspection(String userName, String password);

    Users login(String userName, String password);

    void updUsers(Users user);

     Users getUserByName(String name);

    /*Users getUserById(int id);*/

    /**
     * 得到当前页的数据
     * @param page 就是第几页
     * @return
     */
    PageConfig<Users> getUsersByPage(int page);
}
