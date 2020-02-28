package com.lyq.mapper;

import com.lyq.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
}