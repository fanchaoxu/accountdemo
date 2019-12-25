package com.example.demo.Action;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Utils.Page;
import com.example.demo.Utils.Result;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController{

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/querylist")
    public String queryList(String currentPage,Model model,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        if(session.getAttribute("token") == null){
            return "404";
        } else {
            if(currentPage == null){
                currentPage = "1"; //如果当前页面为空，先跳转到这个页面来
            }
            String rows = String.valueOf(5);
            Page<User> byUser = userService.queryall(currentPage,rows);
            model.addAttribute("userList",byUser);
            return "user";
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestParam("id") int id){
        userService.delete(id);
        Result result = new Result("0","success");
        return result;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id,Model model){
        User user =  userService.query(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam("id") int id,@RequestParam("username") String name,
                       @RequestParam("pwd") String pwd){
        userService.edit(id,name,pwd);
        return "redirect:querylist";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("username") String name,
                      @RequestParam("pwd")String pwd){
        userService.add(name,pwd);
        return "redirect:querylist";
    }




}
