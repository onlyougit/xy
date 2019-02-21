package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Currency;

public interface CurrencyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Currency record);

    int insertSelective(Currency record);

    Currency selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKey(Currency record);
}