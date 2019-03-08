package com.yiya.xq.controller;

import com.yiya.xq.service.UserService;
import com.yiya.xq.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/appApi")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser")
    public Map addUser(UserBean userBean) {
        return userService.addUser(userBean);
    }
}
