package com.sptwin.xy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class HistoryFund {
    private Long id;

    private String clientNo;

    private String currencyNo;

    private BigDecimal capital;

    private BigDecimal account;

    private BigDecimal available;

    private BigDecimal credit;

    private BigDecimal deposit;

    private BigDecimal fee;

    private BigDecimal frozenFund;

    private BigDecimal closeProfit;

    private BigDecimal floatProfit;

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

    public String getCurrencyNo() {
        return currencyNo;
    }

    public void setCurrencyNo(String currencyNo) {
        this.currencyNo = currencyNo == null ? null : currencyNo.trim();
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFrozenFund() {
        return frozenFund;
    }

    public void setFrozenFund(BigDecimal frozenFund) {
        this.frozenFund = frozenFund;
    }

    public BigDecimal getCloseProfit() {
        return closeProfit;
    }

    public void setCloseProfit(BigDecimal closeProfit) {
        this.closeProfit = closeProfit;
    }

    public BigDecimal getFloatProfit() {
        return floatProfit;
    }

    public void setFloatProfit(BigDecimal floatProfit) {
        this.floatProfit = floatProfit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}