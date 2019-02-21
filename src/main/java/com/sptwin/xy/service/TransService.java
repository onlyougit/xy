package com.sptwin.xy.service;

import com.sptwin.xy.utils.ResponseBase;

import java.util.Date;

public interface TransService {

    ResponseBase queryOrder(String clientNo);

    ResponseBase queryOrderHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);

    ResponseBase queryMatch(String clientNo);

    ResponseBase queryMatchHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);

    ResponseBase queryHold(String clientNo);

    ResponseBase queryHoldHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);
}
