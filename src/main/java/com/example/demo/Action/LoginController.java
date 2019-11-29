package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,@RequestParam("pwd")String pwd){
        List<User> user = userMapper.login(username,pwd);
        if(user != null){
            return "success";
        }
        return null;
    }
}
