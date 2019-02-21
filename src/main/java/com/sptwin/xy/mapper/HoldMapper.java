package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Hold;

public interface HoldMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Hold record);

    int insertSelective(Hold record);

    Hold selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Hold record);

    int updateByPrimaryKey(Hold record);
}