package com.sptwin.xy.service;

import com.sptwin.xy.entity.Commodity;
import com.sptwin.xy.pojo.CommodityCustom;
import com.sptwin.xy.utils.ResponseBase;

public interface CommodityService {

    ResponseBase queryCommodityPage(CommodityCustom commodityCustom, Integer pageIndex, Integer pageSize);

    ResponseBase addCommodity(Commodity commodity);

    ResponseBase updateCommodity(Commodity commodity);

    ResponseBase deleteCommodity(Long id);

    ResponseBase queryCommodity(Commodity commodity);

    ResponseBase updateQueryCommodity(Long id);
}
