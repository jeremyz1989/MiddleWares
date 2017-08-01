package com.celnet.dc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.celnet.dc.common.util.StringUtil;
import com.celnet.dc.domain.TAccount;
import com.celnet.dc.domain.TAccountSourceTest1;
import com.celnet.dc.service.TAccountService;
import com.celnet.dc.service.TAccountSourceService;

//@Api("控制页面跳转")
@Controller
@RequestMapping("/page/turns")
@SessionAttributes(value={"cardId","phone"},types={String.class,String.class})
public class PageTurnsController {
	
	@Autowired
	private TAccountSourceService tAccountSourceService;
	
	@Autowired
	private TAccountService tAccountService;
	
	@RequestMapping(value="/welcome",method= RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

	//请求跳转客户合并页面
	@RequestMapping(value="/accountmerge",method= RequestMethod.GET)
    public String accountmerge(ModelMap modelMap){	
List<TAccountSourceTest1> list = tAccountSourceService.getAccountList();
		
		List<TAccountSourceTest1> list2 = tAccountSourceService.getCombineAccountList();
		
		List<TAccount> list1 = tAccountService.getAccount();
		List<TAccount> list3 = new ArrayList<TAccount>();
		if(CollectionUtils.isNotEmpty(list1)){

			for(TAccount tacc : list1){
				if(tacc.getSpareClubregisteredphoneC().length() > 20){
					String[] strArr = tacc.getSpareClubregisteredphoneC().split(";");
					StringBuffer strb = new StringBuffer();
					strb.append(strArr[0]).append(";").append(strArr[1]).append("......");
					System.out.println(strb.toString());
					tacc.setSpareClubregisteredphoneC(strb.toString());
					list3.add(tacc);
				}else{
					list3.add(tacc);
				}
			}
		}else{
			list3 = list1;
		}
		modelMap.addAttribute("sourceAccount", list);
		modelMap.addAttribute("account", list3);
		modelMap.addAttribute("combineAccount", list2);
				
        return "accountmerger";
    }
	
	//根据条件查询指定的客户
	@RequestMapping(value="select",method= RequestMethod.GET)
    public String accountmergeSelect(@RequestParam(value = "cardId") String cardId,
    		@RequestParam(value = "phone") String phone,ModelMap modelMap){
		modelMap.addAttribute("msg", "");
		return accountmergeSelect1(cardId,phone,modelMap);
	}
	
    public String accountmergeSelect1(String cardId, String phone,ModelMap modelMap){
		
		if(StringUtil.isEmpty(cardId)&&StringUtil.isEmpty(phone)){
			// modelMap.addAttribute("pgmsg", "请输入证件号或者手机号！");
			 return accountmerge(modelMap);
		}
		
		if(StringUtil.isNotEmpty(cardId)){
			List<TAccountSourceTest1> list = tAccountSourceService.getAccountListSelectByCardId(cardId);
			
			List<TAccountSourceTest1> list2 = tAccountSourceService.getCombineAccountListByCardId(cardId);
			
			List<TAccount> list1 = tAccountService.getAccountByCardId(cardId);
			List<TAccount> list3 = new ArrayList<TAccount>();
			if(CollectionUtils.isNotEmpty(list1)){
				for(TAccount tacc : list1){
					if(tacc.getSpareClubregisteredphoneC().length() > 20){
						String[] strArr = tacc.getSpareClubregisteredphoneC().split(";");
						StringBuffer strb = new StringBuffer();
						strb.append(strArr[0]).append(";").append(strArr[1]).append("......");
						System.out.println(strb.toString());
						tacc.setSpareClubregisteredphoneC(strb.toString());
						list3.add(tacc);
					}else{
						list3.add(tacc);
					}
				}
			}else{
				list3 = list1;
			}
			
			modelMap.addAttribute("sourceAccount", list);
			modelMap.addAttribute("account", list3);
			modelMap.addAttribute("combineAccount", list2);
		}
		
		if(StringUtil.isNotEmpty(phone)){
			List<TAccountSourceTest1> list = tAccountSourceService.getAccountListSelectByPhone(phone);
			
			List<TAccountSourceTest1> list2 = tAccountSourceService.getCombineAccountListByPhone(phone);
			
			List<TAccount> list1 = tAccountService.getAccountByPhone(phone);
			List<TAccount> list3 = new ArrayList<TAccount>();
			for(TAccount tacc : list1){
				if(tacc.getSpareClubregisteredphoneC().length() > 20){
					String[] strArr = tacc.getSpareClubregisteredphoneC().split(";");
					StringBuffer strb = new StringBuffer();
					strb.append(strArr[0]).append(";").append(strArr[1]).append("......");
					System.out.println(strb.toString());
					tacc.setSpareClubregisteredphoneC(strb.toString());
					list3.add(tacc);
				}else{
					list3 = list1;
				}
			}
			
			modelMap.addAttribute("sourceAccount", list);
			modelMap.addAttribute("account", list3);
			modelMap.addAttribute("combineAccount", list2);
		}
		
		modelMap.addAttribute("cardId", cardId);
		modelMap.addAttribute("phone", phone);
        return "accountmerger";
    }
	
	//合并客户，调用数据库存储过程
	@RequestMapping(value="merger",method= RequestMethod.GET)
    public String mergeAccount(@RequestParam(value = "guid") String[] guid,ModelMap modelMap){
		String cardId = (String) modelMap.get("cardId");
		String phone = (String) modelMap.get("phone");
		if(StringUtil.isNotEmpty(cardId)){
			modelMap.addAttribute("cardId", cardId);
		}
		if(StringUtil.isNotEmpty(phone)){
			modelMap.addAttribute("phone", phone);
		}
		try{
			if(guid.length == 0){
				modelMap.addAttribute("msg", "合并成功");
				return accountmergeSelect(cardId,phone,modelMap);
			}
			for(String str : guid){
				String main_guid = tAccountSourceService.getMainGuid(str);
				tAccountService.callAddData(str,main_guid);
			}
			modelMap.addAttribute("msg", "合并成功");
		}catch (Exception ex){
			modelMap.addAttribute("msg", "合并失败，请反馈后台管理人员查找具体原因");
		}
		
		return accountmergeSelect1(cardId,phone,modelMap);
	}
	
	//拆分客户，调用数据库存储过程
	@RequestMapping(value="split",method= RequestMethod.GET)
    public String splitAccount(@RequestParam(value = "t_guid") String t_guid,ModelMap modelMap){
		String cardId = (String) modelMap.get("cardId");
		String phone = (String) modelMap.get("phone");
		if(StringUtil.isNotEmpty(cardId)){
			modelMap.addAttribute("cardId", cardId);
		}
		if(StringUtil.isNotEmpty(phone)){
			modelMap.addAttribute("phone", phone);
		}
		try{
			String m_guid = tAccountSourceService.getMainGuid(t_guid);

			int record = tAccountSourceService.getCount(m_guid);
			if(record == 1){
				modelMap.addAttribute("msg", "该客户为主档客户，并非合并客户，无法拆分");
				return accountmergeSelect1(cardId,phone,modelMap);
			}
			
			tAccountService.callSplitData(t_guid,m_guid);
			modelMap.addAttribute("msg", "拆分成功");
		}catch (Exception ex){
			modelMap.addAttribute("msg", "拆分失败，请反馈后台管理人员查找具体原因");
		}
		return accountmergeSelect1(cardId,phone,modelMap);
	}
}
