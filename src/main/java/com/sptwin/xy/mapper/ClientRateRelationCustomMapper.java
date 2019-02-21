package com.sptwin.xy.mapper;

import org.apache.ibatis.annotations.Select;

public interface ClientRateRelationCustomMapper {
    @Select("select count(1) from t_client_rate_relation where deposit_template_id = #{id}")
    int queryCountByFeeTemplateId(Integer id);
}