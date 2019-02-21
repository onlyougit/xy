package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Match;

public interface MatchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Match record);

    int insertSelective(Match record);

    Match selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Match record);

    int updateByPrimaryKey(Match record);
}