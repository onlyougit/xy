package com.sptwin.xy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HistoryOrder {
    private Long id;

    private String orderId;

    private String clientNo;

    private String commodityNo;

    private String contractNo;

    private Integer orderType;

    private Integer riskOrder;

    private Integer direct;

    private Integer openOrClose;

    private BigDecimal orderPrice;

    private String currencyNo;

    private Integer orderVol;

    private Date orderTime;

    private BigDecimal matchPrice;

    private Integer matchVol;

    private Integer status;

    private String orderPerson;

    private Date createTime;

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

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo == null ? null : clientNo.trim();
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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getRiskOrder() {
        return riskOrder;
    }

    public void setRiskOrder(Integer riskOrder) {
        this.riskOrder = riskOrder;
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

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getCurrencyNo() {
        return currencyNo;
    }

    public void setCurrencyNo(String currencyNo) {
        this.currencyNo = currencyNo == null ? null : currencyNo.trim();
    }

    public Integer getOrderVol() {
        return orderVol;
    }

    public void setOrderVol(Integer orderVol) {
        this.orderVol = orderVol;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson == null ? null : orderPerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}