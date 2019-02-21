package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.OutInMoney;

public interface OutInMoneyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutInMoney record);

    int insertSelective(OutInMoney record);

    OutInMoney selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutInMoney record);

    int updateByPrimaryKey(OutInMoney record);
}