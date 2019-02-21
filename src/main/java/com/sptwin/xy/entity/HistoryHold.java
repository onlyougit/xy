package com.sptwin.xy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HistoryHold {
    private Long id;

    private String clientNo;

    private String orderId;

    private String commodityNo;

    private String contractNo;

    private Long clientId;

    private Integer direct;

    private BigDecimal holdPrice;

    private Integer holdVol;

    private BigDecimal deposit;

    private Date matchTime;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo == null ? null : clientNo.trim();
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getDirect() {
        return direct;
    }

    public void setDirect(Integer direct) {
        this.direct = direct;
    }

    public BigDecimal getHoldPrice() {
        return holdPrice;
    }

    public void setHoldPrice(BigDecimal holdPrice) {
        this.holdPrice = holdPrice;
    }

    public Integer getHoldVol() {
        return holdVol;
    }

    public void setHoldVol(Integer holdVol) {
        this.holdVol = holdVol;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}