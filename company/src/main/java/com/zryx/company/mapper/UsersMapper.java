package com.zryx.company.mapper;

import com.zryx.company.model.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {

    List<Users> getAllUsers();

    int delUsers(int id);

    //没有实现。
    int addUsers(Users id);

    String getPasswordByUserName(String userName);

    int getStatusByUserName(String userName);

    Users getUserByName(@Param("userName") String userName);

    int updUsers(Users users);

    List<Users> getUsersByPage(@Param("from") int from, @Param("size") int size);

    int dataCount();

}
