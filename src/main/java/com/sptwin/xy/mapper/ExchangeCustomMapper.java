package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Exchange;
import com.sptwin.xy.pojo.ExchangeCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ExchangeCustomMapper {
    List<ExchangeCustom> queryExchangePage();

    @Select("select count(1) from t_exchange where exchange_no = #{exchangeNo}")
    int queryByNo(String exchangeNo);

    @Select("select id,exchange_no exchangeNo, exchange_name exchangeName from t_exchange")
    List<Exchange> queryExchangeNo();

    ExchangeCustom queryById(Long id);
}