package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.Currency;
import com.sptwin.xy.pojo.CurrencyCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CurrencyCustomMapper {
    List<CurrencyCustom> queryCurrencyPage();

    @Select("select count(1) from t_currency where currency_no = #{currencyNo}")
    int queryByNo(String currencyNo);

    @Select("select id,currency_no currencyNo, currency_name currencyName from t_currency")
    List<Currency> queryCurrencyNo();
}