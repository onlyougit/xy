package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RiskOrder {
    A(0, "非风险报单"),
    B(1, "风险报单"),

    ;

    /* 编码 */
    private Integer code;

    /* 描述 */
    private String text;

    public void setCode(Integer code) {
        this.code = code;
    }
    public void setText(String text) {
        this.text = text;
    }
    RiskOrder(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static RiskOrder getEnums(Integer code) {
        for (RiskOrder enums : values()) {
            if (code.equals(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
