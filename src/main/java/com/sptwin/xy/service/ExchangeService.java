package com.sptwin.xy.service;

import com.sptwin.xy.entity.Exchange;
import com.sptwin.xy.utils.ResponseBase;

public interface ExchangeService {

    ResponseBase queryExchangePage(Integer pageIndex, Integer pageSize);

    ResponseBase addExchange(Exchange exchange);

    ResponseBase updateExchange(Exchange exchange);

    ResponseBase queryExchangeNo();

    ResponseBase deleteExchange(Long id);

    ResponseBase updateQueryExchange(Long id);
}
