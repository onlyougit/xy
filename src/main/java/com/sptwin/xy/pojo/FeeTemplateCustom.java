package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.FeeTemplate;
import com.sptwin.xy.entity.FeeTemplateCommodity;
import lombok.Data;

import java.util.List;

@Data
public class FeeTemplateCustom extends FeeTemplate {
    private List<FeeTemplateCommodity> feeTemplateCommodityList;
}
