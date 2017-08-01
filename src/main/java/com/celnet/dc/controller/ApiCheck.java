package com.celnet.dc.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ApiCheck {

	/**
     * 1、callin，header验证
     * 2、callout，header加密
     * 3、数据质量提升（数据补全）
     * 
     * @param joinPoint
     * @throws Throwable
     */
    @Pointcut("within(com.celnet.dc.controller.InterfaceServiceController)")
    public void apiCheck(){}
    
    @Before("apiCheck()")
     public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        System.out.println("请求地址 : " + request.getRequestURL().toString());
        System.out.println("HTTP METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        System.out.println("参数 : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("请求时间：" + System.currentTimeMillis());
       
    }
    
    @AfterReturning(returning = "ret", pointcut = "apiCheck()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
    	System.out.println("结束时间：" + System.currentTimeMillis());
    	System.out.println("RESPONSE : " + ret);
    }
    
}
