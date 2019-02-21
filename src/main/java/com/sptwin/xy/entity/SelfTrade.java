package com.sptwin.xy.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SelfTrade {
    private Long id;

    private String account;

    private String exchange;

    private String name;

    private String contract;

    private String buySell;

    private BigDecimal tradeprice;

    private BigDecimal orderprice;

    private String tradecount;

    private String fee;

    private String optionfee;

    private String exchangedate;

    private String exchangetime;

    private String exchangetradenumber;

    private String tradedate;

    private String tradetime;

    private String ordercontract;

    private String contracttype;

    private String tradesource;

    private String ordertype;

    private String ordernumber;

    private String tradenumber;

    private String systemnumber;

    private String orderuser;

    private String currency;

    private String streamnumber;

    private String openclose;

    private String closeprofit;

    private String usernumber;

    private String tdata;

}