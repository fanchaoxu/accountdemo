package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Utils.Page;

public interface UserService{
    public Page<User> queryall(String currentPage,String rows);


    public int count();
}
