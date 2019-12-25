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
    public User login(String username,String pwd){
        User user = userMapper.login(username,pwd);
        return user;
    }

    @Override
    public int delete(int id){
        return userMapper.delete(id);
    }

    @Override
    public int edit(int id,String name,String pwd){
        return userMapper.edit(id,name,pwd);
    }

    @Override
    public User query(int id){
        User user = userMapper.query(id);
        return user;
    }

    @Override
    public int add(String username,String pwd){
        return userMapper.add(username,pwd);
    }

}
