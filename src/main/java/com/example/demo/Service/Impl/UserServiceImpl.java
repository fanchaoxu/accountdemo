package com.example.demo.Service.Impl;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Resource(name = "UserMapper")
    private UserMapper userMapper;


    @Override
    public Page<User> queryall(String _currentPage,String _rows){
        Page<User> page = new Page<>();

        int currentPage = Integer.parseInt(_currentPage); //获取到当前的页面
        int rows = Integer.parseInt(_rows);
        int totalCount = userMapper.count();
        int totalPage = (totalCount % rows == 0) ? (totalCount / rows) : (totalCount / rows + 1); //总页数
        int start = (currentPage - 1) * rows; //起始位置
        System.out.println(start + "*********************");
        List<User> list = userMapper.queryAll(start,rows);

        page.setRows(rows);
        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
        page.setList(list);


        return page;
    }

    @Override
    public int count(){
        int size = userMapper.count();
        return size;
    }

    @Override
    public List<User> login(String username,String pwd){
        List<User> user = userMapper.login(username,pwd);
        return user;
    }
}
