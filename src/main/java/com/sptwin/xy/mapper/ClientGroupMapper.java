package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.ClientGroup;

public interface ClientGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientGroup record);

    int insertSelective(ClientGroup record);

    ClientGroup selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientGroup record);

    int updateByPrimaryKey(ClientGroup record);
}