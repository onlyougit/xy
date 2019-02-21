package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Commodity;
import com.sptwin.xy.enums.CommodityStatus;
import lombok.Data;

@Data
public class CommodityCustom extends Commodity {
    private CommodityStatus commodityStatusEnum;
}
