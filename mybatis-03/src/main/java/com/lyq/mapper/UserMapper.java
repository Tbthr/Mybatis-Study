package com.lyq.mapper;

import com.lyq.model.User;

import java.util.List;

public interface UserMapper {

    //查询所有
    List<User> selectUser();

    //根据ID查询
    User selectUserById(int id);

    //增加一条数据
    int addUser(User user);

    //根据ID更新一条数据;
    int updateUserById(User user);

    //根据ID删除一条数据
    int deleteUserById(int id);
}