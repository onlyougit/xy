package com.sptwin.xy.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class Contract {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("品种编号")
    private String commodityNo;

    @ApiModelProperty("市场编号")
    private String exchangeNo;

    @ApiModelProperty("合约编号")
    private String contractNo;

    @ApiModelProperty("合约名称")
    private String contractName;

    @ApiModelProperty("最后一次交易时间")
    private Date lastTradeDate;

    @ApiModelProperty("是不是主力合约")
    private Integer mainContract;

    @ApiModelProperty("状态")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public String getExchangeNo() {
        return exchangeNo;
    }

    public void setExchangeNo(String exchangeNo) {
        this.exchangeNo = exchangeNo == null ? null : exchangeNo.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public Date getLastTradeDate() {
        return lastTradeDate;
    }

    public void setLastTradeDate(Date lastTradeDate) {
        this.lastTradeDate = lastTradeDate;
    }

    public Integer getMainContract() {
        return mainContract;
    }

    public void setMainContract(Integer mainContract) {
        this.mainContract = mainContract;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}