package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.FeeTemplate;
import com.sptwin.xy.entity.FeeTemplateCommodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FeeTemplateCustomMapper {
    void batchInsert(List<FeeTemplateCommodity> feeTemplateCommodityList);

    void insertSelective(FeeTemplate feeTemplate);

    @Select("select count(1) from t_fee_template where fee_template_name = #{feeTemplateName}")
    int queryCountByNo(String feeTemplateName);

    List<FeeTemplate> queryFeeTemplatePage(Integer type);

    List<FeeTemplateCommodity> queryFeeTemplateCommodityPage(Integer feeTemplateId);

    @Delete("delete from t_fee_template_commodity where fee_template_id = #{id}")
    void batchDeleteFeeTemplateCommodity(Integer id);
}