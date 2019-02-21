package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.CreditMoney;
import com.sptwin.xy.entity.Fund;
import com.sptwin.xy.entity.HistoryFund;
import com.sptwin.xy.pojo.OutInMoneyCustom;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FundCustomMapper {
    List<Fund> queryFund(@Param("clientNo") String clientNo,
                         @Param("list") List<String> list);

    List<OutInMoneyCustom> queryFundOutIn(@Param("clientNo") String clientNo,
                                              @Param("list") List<String> list);

    List<CreditMoney> queryFundCredit(@Param("clientNo") String clientNo,
                                          @Param("list") List<String> list);

    List<OutInMoneyCustom> queryFundOutInHistoryPage(@Param("startDate") Date startDate,
                                                     @Param("endDate") Date endDate,
                                                     @Param("clientNo") String clientNo,
                                                     @Param("list") List<String> list);

    List<CreditMoney> queryFundCreditHistoryPage(@Param("startDate") Date startDate,
                                                 @Param("endDate") Date endDate,
                                                 @Param("clientNo") String clientNo,
                                                 @Param("list") List<String> list);

    List<HistoryFund> queryFundHistoryPage(@Param("startDate") Date startDate,
                                           @Param("endDate") Date endDate,
                                           @Param("clientNo") String clientNo,
                                           @Param("list") List<String> list);
}