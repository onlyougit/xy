package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.HistoryOrder;

public interface HistoryOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryOrder record);

    int insertSelective(HistoryOrder record);

    HistoryOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryOrder record);

    int updateByPrimaryKey(HistoryOrder record);
}