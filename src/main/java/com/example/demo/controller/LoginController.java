package com.example.demo.controller;

import com.example.demo.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello Word";
    }
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession httpSession){
        if (!StringUtils.isEmpty(username) && "123".equals(password)){
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户密码错误");
            return "login";
        }
    }
}
