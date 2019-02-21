package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Exchange;

public interface ExchangeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Exchange record);

    int insertSelective(Exchange record);

    Exchange selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Exchange record);

    int updateByPrimaryKey(Exchange record);
}