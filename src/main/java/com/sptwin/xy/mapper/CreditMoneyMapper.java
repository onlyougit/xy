package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.CreditMoney;

public interface CreditMoneyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditMoney record);

    int insertSelective(CreditMoney record);

    CreditMoney selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditMoney record);

    int updateByPrimaryKey(CreditMoney record);
}