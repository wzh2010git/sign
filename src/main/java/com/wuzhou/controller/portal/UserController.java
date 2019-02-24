package com.wuzhou.controller.portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public class UserController {
    public String login(String userName, String password) {
        System.out.println("login success");
        return  "login success";
    }
}
