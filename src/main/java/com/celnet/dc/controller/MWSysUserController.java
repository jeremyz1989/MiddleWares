package com.celnet.dc.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.celnet.dc.domain.MWSysUser;
import com.celnet.dc.service.MWSysUserService;

/**
 * 用户-控制层
 *
 * Created by ensure 2017-06-17.
 */
//@Api("系统登录用户管理")
@Controller
@RequestMapping("/page/user")
public class MWSysUserController {
	// 创建线程安全的Map
	//static Map<String, MWSysUser> MWSysUsers = Collections.synchronizedMap(new HashMap<String, MWSysUser>());
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MWSysUserService mwSysUserService;

	@RequestMapping("index")
	public String index(Model model) {
		//model.addAttribute("xname", name);
		//日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String login(@RequestParam(value = "userName",	 required = true) String username,
			 @RequestParam(value = "passWord",	 required = true) String password,ModelMap modelMap) {
		 String retStr="login";
		 System.out.println(username + "**********" + password);
		 MWSysUser mwSysUser = mwSysUserService.selectByName(username);
		 System.out.println("***********" + mwSysUser.getPassword());
		 
		 if(mwSysUser==null){
			 modelMap.addAttribute("pgmsg", "用户名错误！");
		 }else if(!mwSysUser.getPassword().equals(password)){
			 modelMap.addAttribute("pgmsg", "密码错误！");
		 }else{
			 modelMap.addAttribute("user",mwSysUser);
			 retStr="welcome";
		 }
	 return retStr;
	 }
	 
//	 @ModelAttribute("user")  //获取页面传递参数  
//	 public MWSysUser insert() {    
//	    return new User("jz","123");    
//	 }    
	   
//	 @RequestMapping(value = "/helloWorld")    
//	 public String helloWorld(@ModelAttribute("mwSysUser") MWSysUser user) {    
//	    user.setUsername("jizhou");    
//	    return "helloWorld";    
//	 } 
	// @RequestMapping(value = "/update", method = RequestMethod.GET)
	// public int updateByPrimaryKey(
	// @RequestParam(value = "MWSysUser", required = true) MWSysUser
	// MWSysUser) {
	// int retCnt = MWSysUserService.updateByPrimaryKey(MWSysUser);
	// return retCnt;
	// }
	//
	// @RequestMapping(value = "/updateSel", method = RequestMethod.GET)
	// public int updateByPrimaryKeySelective(
	// @RequestParam(value = "MWSysUser", required = true) MWSysUser
	// MWSysUser) {
	// int retCnt =
	// MWSysUserService.updateByPrimaryKeySelective(MWSysUser);
	// return retCnt;
	// }
	//
	// @RequestMapping(value = "/updateSel", method = RequestMethod.GET)
	// public int deleteByPrimaryKey(@RequestParam(value = "id", required =
	// true) Integer id) {
	// int retCnt = MWSysUserService.deleteByPrimaryKey(id);
	// return retCnt;
	// }

}