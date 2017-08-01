package com.celnet.dc.dao;

import java.util.List;

import com.celnet.dc.domain.ComplaintsAdviceC;

public interface ComplaintsAdviceCMapper {

    ComplaintsAdviceC selectByPrimaryKey(Integer id);
    
    //定时扫描投诉建议表
    List<ComplaintsAdviceC> selectData();
    //更新工单id
    int updateWoId(ComplaintsAdviceC complaint);

}