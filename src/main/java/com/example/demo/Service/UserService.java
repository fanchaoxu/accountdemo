package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Utils.Page;
import org.apache.ibatis.annotations.Param;



public interface UserService{
    public Page<User> queryall(String currentPage,String rows);

    public int count();

    public User login(@Param("username") String username,@Param("pwd") String pwd);

    public int delete(@Param("id") int id);

    public int edit(@Param("id")int id,@Param("username")String name,@Param("pwd")String pwd);

    public User query(@Param("id") int id);

    public int add(@Param("username") String username,@Param("pwd") String pwd);
}
