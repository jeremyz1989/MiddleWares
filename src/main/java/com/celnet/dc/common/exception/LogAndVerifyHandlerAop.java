package com.celnet.dc.common.exception;

//import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAndVerifyHandlerAop {
    /**
     * 打印日志
     * */
//    Logger log = LoggerFactory.getLogger(LogAndVerifyHandlerAop.class);

//    private Gson gson = new Gson() ;

    /**
     * AOP切面中的同步问题：用于监控业务处理性能
     */
    private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>() ;

    @Pointcut("execution(* com.chervon.iot.ablecloud.service..*(..))")
    public void logControllerAspect(){}

    //请求method前打印内容
    @Before(value = "logControllerAspect()")
    public void methodBefore(JoinPoint joinPoint) throws VerifyException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容
//        log.info("===============请求内容===============");
//        log.info("请求地址:"+request.getRequestURL().toString());
//        log.info("请求方式:"+request.getMethod());
//        log.info("请求类方法:"+joinPoint.getSignature());
//        log.info("请求类方法参数:"+ Arrays.toString(joinPoint.getArgs()));
//        log.info("===============请求内容===============");
        threadLocal.set(System.currentTimeMillis());

        if(true) {
            ErrorInfo<String> r = new ErrorInfo<>();
            r.setCode(400);
            r.setMessage("你错了！");
            throw new VerifyException(r);
        }
    }


    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o",pointcut = "logControllerAspect()")
    public void methodAfterReturing(Object o ){
//        log.info("--------------返回内容----------------");
//        log.info("Response内容:"+gson.toJson(o));
//        log.info("--------------返回内容----------------");
//        log.error("-----请求返回时间="+(System.currentTimeMillis()-threadLocal.get()));
    }
}
