package com.celnet.dc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.celnet.dc.domain.MWSysUser;
import com.celnet.dc.domain.TAccount;
import com.celnet.dc.service.TAccountService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "page/turns")
@Api("客户合并-相关api") // 用在类上，说明该类的作用
public class AccountMergerController {
	
	@Autowired
	private TAccountService tAccountService;

//	@RequestMapping(value = "/main/account", method = RequestMethod.GET)
//	 public String login(@RequestParam(value = "guid",	 required = true) String guid,ModelMap modelMap) {
//		 List<TAccount> list = tAccountService.getAccount(guid);
//		 System.out.println("**********88" + guid);
//			 modelMap.addAttribute("account",list);
//	 return "welcome";
//	 }
}
