package com.zhaobo.cruddemo.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    ServletContext application;
/**
 *  页面请求只要进入这个控制器，不管请求那个方法，均会先执行被@ModelAttribute标记的方法，
 所以我们可以用@ModelAttribute注解的方法做一些初始化操作。当同一个controller中有多
 个方法被@ModelAttribute注解标记，所有被@ModelAttribute标记的方法均会被执行，按先
 后顺序执行，然后再进入请求的方法。
 */

    @ModelAttribute
    private void set(HttpServletRequest request,HttpServletResponse response){
        this.request = request;
        this.response = response;
        session = request.getSession();
        application = request.getServletContext();
    }
}
