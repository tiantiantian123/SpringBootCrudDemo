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
    //advice：拦截到方法后要执行的动作
    //*(..)表示AopController中所有的带参数的方法，而*()表示所有不带参数的方法。下面的logger.info("参数={}",joinPoint.getArgs())想要获取到参数就要用前者并且方法也确实有参数
    @Pointcut("execution(public * com.zhaobo.cruddemo.controller.AopController.*(..))")
    public void log(){}
    /**
     * 记录HTTP请求开始时的日志
     */
//常见的四种切面有：before（在方法执行前执行advice）,after（在方法执行完成后执行，无论是执行成功还是抛出异常）,afterreturning（仅在方法执行成功后执行）,afterthrowing（仅在方法抛出异常后执行）
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {}",request.getRequestURI());
        logger.info("method = {}",request.getMethod());
        logger.info("ip = {}",request.getRemoteAddr());
        logger.info("class = {} and method name = {}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        logger.info("参数 = {}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution",request.getRequestURL());
    }

    @AfterReturning(returning = "o",pointcut = "log()")
    public void doAfterReturn(Object o){
        logger.info("response = {}",o.toString());
    }
}
