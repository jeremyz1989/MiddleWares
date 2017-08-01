package com.celnet.dc.quartz;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.celnet.dc.controller.OrderCreateController;
import com.celnet.dc.dao.ComplaintsAdviceCMapper;
import com.celnet.dc.domain.ComplaintsAdviceC;

public class ScheduleTaskSay implements Job{
	
	@Autowired
	private ComplaintsAdviceCMapper complaintsAdviceCMapper;
	@Autowired
	private OrderCreateController orderCreateController;
	
	
	    @Override
	    public void execute(JobExecutionContext context) throws JobExecutionException {
	    	
	    	//定时扫描投诉建议表，有符合条件的数据调用接口推送
	    	List<ComplaintsAdviceC> list = complaintsAdviceCMapper.selectData();
	    	if(CollectionUtils.isEmpty(list)){
	    		System.out.println("空空空空空空空空空空空");
	    	}else{
	    		//调用接口
	    		orderCreateController.createOrderList(list);
	    	}
	    	
	    }
	
}