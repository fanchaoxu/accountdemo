package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Utils.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserService{
    public Page<User> queryall(String currentPage,String rows);

    public int count();

    public List<User> login(@Param("username") String username,@Param("pwd") String pwd);

    public int delete(@Param("id") int id);
}
