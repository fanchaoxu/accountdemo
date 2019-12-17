package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class AccountController{

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/querylist")
    public String queryList(String currentPage,Model model) throws Exception{
        if(currentPage == null){
            currentPage = "1"; //如果当前页面为空，先跳转到这个页面来
        }
        String rows = String.valueOf(2);
        Page<User> byUser = userService.queryall(currentPage,rows);
        model.addAttribute("userList",byUser);
        return "user";
    }

}
