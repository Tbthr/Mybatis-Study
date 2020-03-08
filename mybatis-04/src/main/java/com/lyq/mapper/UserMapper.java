package com.lyq.mapper;

import com.lyq.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

   //分页
    List<User> getUserByLimit(Map<String,Integer> map);

    //选择全部用户RowBounds实现分页
    List<User> getUserByRowBounds();
}