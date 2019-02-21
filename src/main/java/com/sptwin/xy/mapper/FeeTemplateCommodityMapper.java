package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.FeeTemplateCommodity;

public interface FeeTemplateCommodityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FeeTemplateCommodity record);

    int insertSelective(FeeTemplateCommodity record);

    FeeTemplateCommodity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FeeTemplateCommodity record);

    int updateByPrimaryKey(FeeTemplateCommodity record);
}