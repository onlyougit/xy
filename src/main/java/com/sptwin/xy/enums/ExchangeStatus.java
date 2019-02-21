package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ExchangeStatus {
    N("N", "禁止交易"),

    Y("Y", "允许交易"),

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

    ExchangeStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    public static ExchangeStatus getEnums(String code) {
        for (ExchangeStatus enums : values()) {
            if (code.equalsIgnoreCase(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
