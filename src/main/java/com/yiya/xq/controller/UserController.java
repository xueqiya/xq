package com.yiya.xq.controller;

import com.yiya.xq.bean.ResultBean;
import com.yiya.xq.service.UserService;
import com.yiya.xq.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appApi")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public ResultBean login(UserBean userBean) {
        return userService.login(userBean);
    }
    @RequestMapping(value = "/register")
    public ResultBean register(UserBean userBean) {
        return userService.register(userBean);
    }
}
