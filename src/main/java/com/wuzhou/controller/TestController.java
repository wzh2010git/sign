package com.wuzhou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @ResponseBody
    @RequestMapping("/test.do")
    public String test(){
        System.out.println(" test wuzhou....");
        return  "666";
    }
}
