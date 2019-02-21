package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.HistoryHold;

public interface HistoryHoldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryHold record);

    int insertSelective(HistoryHold record);

    HistoryHold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryHold record);

    int updateByPrimaryKey(HistoryHold record);
}