package com.sptwin.xy.entity;

public class FeeTemplate {
    private Integer id;

    private String feeTemplateName;

    private Integer type;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeeTemplateName() {
        return feeTemplateName;
    }

    public void setFeeTemplateName(String feeTemplateName) {
        this.feeTemplateName = feeTemplateName == null ? null : feeTemplateName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}