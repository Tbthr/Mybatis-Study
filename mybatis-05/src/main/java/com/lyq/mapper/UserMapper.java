package com.lyq.mapper;

import com.lyq.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //查询全部用户
    @Select("select id,name,pwd password from user")
    List<User> getAllUser();

    //添加一个用户
    @Insert("insert into user (name,pwd) values (#{name},#{pwd})")
    int addUser(@Param("name")String name,@Param("pwd")String password);

    //修改一个用户
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    //根据id删除用
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id")int id);
}