package com.sptwin.xy.service;

import com.sptwin.xy.entity.CreditMoney;
import com.sptwin.xy.entity.OutInMoney;
import com.sptwin.xy.utils.ResponseBase;

import java.util.Date;

public interface FundService {

    ResponseBase queryFund(String clientNo);

    ResponseBase queryFundOutIn(String clientNo);

    ResponseBase queryFundCredit(String clientNo);

    ResponseBase queryFundOutInHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);

    ResponseBase queryFundCreditHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);

    ResponseBase queryFundHistoryPage(Date startDate, Date endDate, String clientNo, Integer pageIndex, Integer pageSize);

    ResponseBase addOutInMoney(OutInMoney outInMoney);

    ResponseBase addCreditMoney(CreditMoney creditMoney);
}
