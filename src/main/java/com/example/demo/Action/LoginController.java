package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Utils.Result;
import com.example.demo.Utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestParam("username") String username,@RequestParam("pwd")String pwd,
                        HttpServletRequest request) throws IOException{

        HttpSession session = request.getSession();
        String code = request.getParameter("code").toUpperCase();
        String imgCode = request.getSession().getAttribute("randomcode_key").toString().toUpperCase();
        if(code.equals(imgCode)){
            User user = userMapper.login(username,pwd);
            if(user != null){
                TokenGenerator tokenGenerator = new TokenGenerator();
                String token = tokenGenerator.createToken();
                session.setAttribute("token",token);
                Result result = new Result("0","success");
                return result;
            }
        }
        return null;
    }
}
