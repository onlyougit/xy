package com.sptwin.xy.entity;

import java.math.BigDecimal;
import java.util.Date;

public class FeeTemplateCommodity {
    private Long id;

    private Integer feeTemplateId;

    private String commodityNo;

    private String commodityName;

    private BigDecimal fee;

    private Date modifyDateTime;

    private Integer userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFeeTemplateId() {
        return feeTemplateId;
    }

    public void setFeeTemplateId(Integer feeTemplateId) {
        this.feeTemplateId = feeTemplateId;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(Date modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}