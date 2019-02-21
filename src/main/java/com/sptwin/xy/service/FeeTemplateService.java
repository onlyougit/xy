package com.sptwin.xy.service;

import com.sptwin.xy.entity.FeeTemplateCommodity;
import com.sptwin.xy.pojo.FeeTemplateCustom;
import com.sptwin.xy.utils.ResponseBase;

public interface FeeTemplateService {

    ResponseBase addFeeTemplate(FeeTemplateCustom feeTemplateCustom);

    ResponseBase updateFeeTemplate(FeeTemplateCommodity feeTemplateCommodity);

    ResponseBase queryFeeTemplatePage(Integer type, Integer pageIndex, Integer pageSize);

    ResponseBase queryFeeTemplateCommodityPage(Integer feeTemplateId, Integer pageIndex, Integer pageSize);

    ResponseBase deleteFeeTemplate(Integer id);

    ResponseBase updateQueryFeeTemplate(Long id);
}
