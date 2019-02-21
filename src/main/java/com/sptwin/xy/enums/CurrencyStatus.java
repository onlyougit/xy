package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CurrencyStatus {
    N("N", "非基准货币"),

    Y("Y", "基准货币"),

    ;
    /* 编码 */
    private String code;

    /* 描述 */
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    CurrencyStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    public static CurrencyStatus getEnums(String code) {
        for (CurrencyStatus enums : values()) {
            if (code.equalsIgnoreCase(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
