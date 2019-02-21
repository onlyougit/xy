package com.sptwin.xy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Match {
    private Long id;

    private String orderId;

    private String commodityNo;

    private String currencyNo;

    private String contractNo;

    private String clientNo;

    private Integer direct;

    private Integer openOrClose;

    private BigDecimal matchPrice;

    private Integer matchVol;

    private Date matchTime;

    private BigDecimal fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public String getCurrencyNo() {
        return currencyNo;
    }

    public void setCurrencyNo(String currencyNo) {
        this.currencyNo = currencyNo == null ? null : currencyNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo == null ? null : clientNo.trim();
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public Integer getOpenOrClose() {
        return openOrClose;
    }

    public void setOpenOrClose(Integer openOrClose) {
        this.openOrClose = openOrClose;
    }

    public BigDecimal getMatchPrice() {
        return matchPrice;
    }

    public void setMatchPrice(BigDecimal matchPrice) {
        this.matchPrice = matchPrice;
    }

    public Integer getMatchVol() {
        return matchVol;
    }

    public void setMatchVol(Integer matchVol) {
        this.matchVol = matchVol;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}