package com.sptwin.xy.service;

import com.sptwin.xy.entity.Currency;
import com.sptwin.xy.utils.ResponseBase;

public interface CurrencyService {

    ResponseBase queryCurrencyPage(Integer pageIndex, Integer pageSize);

    ResponseBase addCurrency(Currency currency);

    ResponseBase updateCurrency(Currency currency);

    ResponseBase queryCurrencyNo();

    ResponseBase updateQueryCurrency(Long id);
}
