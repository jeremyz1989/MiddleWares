package com.celnet.dc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celnet.dc.dao.ComplaintsAdviceCMapper;
import com.celnet.dc.domain.ComplaintsAdviceC;
import com.celnet.dc.service.ComplaintAdviceService;

@Service
public class ComplaintAdviceServiceImpl implements ComplaintAdviceService {
	
	@Autowired
	private ComplaintsAdviceCMapper complaintsAdviceCMapper;

	@Override
	public int updateWoId(ComplaintsAdviceC complaint) {
		return complaintsAdviceCMapper.updateWoId(complaint);
	}

	
	
}
