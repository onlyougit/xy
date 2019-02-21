package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Commodity;
import com.sptwin.xy.pojo.CommodityCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommodityCustomMapper {
    List<CommodityCustom> queryCommodityPage(CommodityCustom commodityCustom);

    @Select("select count(1) from t_commodity where commodity_no = #{commodityNo}")
    int queryCountByNo(String currencyNo);

    @Select("select count(1) from t_commodity where exchange_no = #{exchangeNo}")
    int queryCountByExchangeNo(String exchangeNo);

    List<CommodityCustom> queryContract(Commodity commodity);
}