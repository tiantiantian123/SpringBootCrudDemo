package com.zhaobo.cruddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cruddemo
 * @description: controller built for aop test
 * @author: Mr.Zhao
 * @create: 2018-05-08 09:52
 **/

@RestController
public class AopController {
    @GetMapping(value = "/aoptest")
    public String aopTest(){
        return "AOP test successfully!";
    }
}
