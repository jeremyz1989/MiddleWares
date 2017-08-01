package com.celnet.dc.quartz;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.celnet.dc.controller.PushHouseBindingController;
import com.celnet.dc.dao.AccountSourceMapper;
import com.celnet.dc.domain.AccountSource;
import com.celnet.dc.service.AccountSourceService;
import com.celnet.dc.service.impl.AccountSourceServiceImpl;


public class ScheduleTaskDo implements Job{
	
		@Resource
		private AccountSourceService accountSourceService;
		
		
		PushHouseBindingController pushHouseBindingController = new PushHouseBindingController();
	
//	ClassPathXmlApplicationContext context = ApplicationContextHelper.getGlobalContext();
//	AccountSourceService accountsourceService = (AccountSourceService) context.getBean("accountsourceService");
		
		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			List<AccountSource> retList = accountSourceService.getAccount();
			System.out.println("****************************************88");
	    	if(CollectionUtils.isNotEmpty(retList)){
	    		//调用推送接口
	    		try {
					pushHouseBindingController.pushAccount(retList);
				} catch (NoSuchAlgorithmException e) {
					System.out.println("捕获异常");
				}
	    	}
		}	
	
}
