package com.celnet.dc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.io.IOUtils; 


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
        
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
        	String str = headerNames.nextElement();
        	System.out.println("请求头：" + str + ":" + request.getHeader(str));
        }
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
