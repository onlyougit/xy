package com.sptwin.xy.entity;

public class ClientRateRelation {
    private Long id;

    private String clientNo;

    private Long depositTemplateId;

    private Long feeTemplateId;

    private Long riskTemplateId;

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

    public Long getDepositTemplateId() {
        return depositTemplateId;
    }

    public void setDepositTemplateId(Long depositTemplateId) {
        this.depositTemplateId = depositTemplateId;
    }

    public Long getFeeTemplateId() {
        return feeTemplateId;
    }

    public void setFeeTemplateId(Long feeTemplateId) {
        this.feeTemplateId = feeTemplateId;
    }

    public Long getRiskTemplateId() {
        return riskTemplateId;
    }

    public void setRiskTemplateId(Long riskTemplateId) {
        this.riskTemplateId = riskTemplateId;
    }
}