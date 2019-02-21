package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.ClientAgent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientAgentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientAgent record);

    int insertSelective(ClientAgent record);

    ClientAgent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientAgent record);

    int updateByPrimaryKey(ClientAgent record);
}