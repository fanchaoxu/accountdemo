package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper{
    @Select("select * from user_info where user_name =#{username}")
    List<User> login(@Param("username") String username,@Param("pwd")String pwd);
}
