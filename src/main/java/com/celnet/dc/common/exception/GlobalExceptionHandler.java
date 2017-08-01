package com.celnet.dc.common.exception;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mike on 2017/6/22.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("error");
//        return mav;
//    }

    @ExceptionHandler(value = VerifyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, VerifyException e) throws Exception {
//        ErrorInfo<String> r = e.getErrorInfo();
//        r.setMessage(e.getMessage());
//        r.setCode(ErrorInfo.ERROR);
//        r.setData("Some Data");
//        r.setUrl(req.getRequestURL().toString());
        return  e.getErrorInfo();
    }
}
