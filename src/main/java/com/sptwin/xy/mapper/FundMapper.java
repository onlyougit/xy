package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}