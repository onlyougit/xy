package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.FeeTemplate;

public interface FeeTemplateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FeeTemplate record);

    int insertSelective(FeeTemplate record);

    FeeTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FeeTemplate record);

    int updateByPrimaryKey(FeeTemplate record);
}