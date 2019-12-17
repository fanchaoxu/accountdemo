package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map login(@RequestParam("username") String username,@RequestParam("pwd")String pwd,
                        HttpServletRequest request) throws IOException{

        //得到一个session的对象，然后后面把登录之后产生的token放到session之中
        HttpSession session = request.getSession(false);

        Map<String,String> result = new HashMap<>();
        String code = request.getParameter("code").toUpperCase();
        String imgCode = request.getSession().getAttribute("randomcode_key").toString().toUpperCase();
        boolean flag = false;
        if(code.equals(imgCode)){
           /* List<User> user = userMapper.login(username,pwd);

            if(user != null){
                TokenGenerator tokenGenerator = new TokenGenerator();
                //创建一个自定义的token
                String token = tokenGenerator.createToken();
                session.setAttribute("token",token);
                result.put("flag","true");
            }*/
        }
        return result;
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String index(){
        return "success";
    }

}
