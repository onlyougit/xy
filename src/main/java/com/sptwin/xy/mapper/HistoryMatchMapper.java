package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.HistoryMatch;

public interface HistoryMatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HistoryMatch record);

    int insertSelective(HistoryMatch record);

    HistoryMatch selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HistoryMatch record);

    int updateByPrimaryKey(HistoryMatch record);
}