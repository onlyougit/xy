package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.HistoryFund;

public interface HistoryFundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryFund record);

    int insertSelective(HistoryFund record);

    HistoryFund selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryFund record);

    int updateByPrimaryKey(HistoryFund record);
}