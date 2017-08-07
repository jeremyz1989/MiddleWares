package com.celnet.dc.dao;

import com.celnet.dc.domain.WeChatFollower;

public interface WeChatFollowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatFollower record);

    int insertSelective(WeChatFollower record);

    WeChatFollower selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatFollower record);

    int updateByPrimaryKey(WeChatFollower record);
}