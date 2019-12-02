package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController{
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,@RequestParam("pwd")String pwd,
                        HttpServletRequest request) throws IOException{
        String code = request.getParameter("code").toUpperCase();
        String imgCode = request.getSession().getAttribute("randomcode_key").toString().toUpperCase();
        boolean flag = false;
        if(code.equals(imgCode)){
            List<User> user = userMapper.login(username,pwd);
            if(user != null){
                return "ture";
            }
        }
        return "false";
    }
}
