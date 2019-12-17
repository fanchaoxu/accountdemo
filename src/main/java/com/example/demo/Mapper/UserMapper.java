package com.example.demo.Mapper;

import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository(value = "UserMapper")
public interface UserMapper{

    public int count();

    public List<User> queryAll(int start,int row);
}
