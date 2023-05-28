package com.example.controller;


import com.example.entity.User;
import com.example.service.UserServiceImpl;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping()
    public String addUser(HttpServletRequest request, User user) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {

        } else {

        }

        if (userService.findUser(user.getUsername()) != null) {
            return Result.failGetString("用户名已存在");
        } else {
            int result = userService.addUser(user);
            return Result.okGetString("插入成功",user);
        }

    }

    @DeleteMapping()
    public String delUser(HttpServletRequest request, User user) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {

        } else {

        }

        String message = userService.delUserById(user.getId());

        if (message.equals("1")) {
            return Result.okGetString("删除成功",user);
        } else if (message.equals("0")) {
            return Result.failGetString("删除失败 原因：没有找到该用户的编号");
        } else {
            return Result.failGetString("删除失败");
        }

    }

    @PutMapping()
    public String updateUser(HttpServletRequest request, User user) {

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {

        } else {

        }

        int message = userService.updateUserById(user);

        if (message == 1) {
            return Result.okGetString("更新成功",user);
        } else {
            return Result.failGetString("更新失败");
        }

    }
}
