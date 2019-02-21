package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ContractStatus {
    Y("Y", "允许交易"),

    N("N", "禁止交易"),

    C("C", "只可平仓"),

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

    ContractStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    public static ContractStatus getEnums(String code) {
        for (ContractStatus enums : values()) {
            if (code.equalsIgnoreCase(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
