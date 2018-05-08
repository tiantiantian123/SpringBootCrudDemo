package com.zhaobo.cruddemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: cruddemo
 * @description: aop编程
 * @author: Mr.Zhao
 * @create: 2018-05-08 09:25
 **/

@Aspect
@Component
public class HttpAspect {

    //使用org.slf4j.Logger,这是spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
    //Pointcut: 切点，用于定义哪个方法会被拦截，例如 execution(* cn.springcamp.springaop.service.*.*(..))
    @Pointcut("execution(public * com.zhaobo.cruddemo.controller.AopController.*())")
    public void log(){}
    /**
     * 记录HTTP请求开始时的日志
     */

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURI());
        logger.info("method={}",request.getMethod());
        logger.info("ip={}",request.getRemoteAddr());
        logger.info("class={} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        logger.info("参数 = {}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={} end of execution",request.getRequestURL());
    }

    @AfterReturning(returning = "o",pointcut = "log()")
    public void doAfterReturn(Object o){
        logger.info("response={}",o.toString());
    }
}
