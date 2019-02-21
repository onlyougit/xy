package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ClientStatus{
    Y("Y", "允许交易"),

    N("N", "禁止交易"),

    C("C", "只可平仓"),

    D("D", "禁止登录"),

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

    ClientStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    public static ClientStatus getEnums(String code) {
        for (ClientStatus enums : values()) {
            if (code.equalsIgnoreCase(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
