package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.ClientRateRelation;

public interface ClientRateRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientRateRelation record);

    int insertSelective(ClientRateRelation record);

    ClientRateRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientRateRelation record);

    int updateByPrimaryKey(ClientRateRelation record);
}