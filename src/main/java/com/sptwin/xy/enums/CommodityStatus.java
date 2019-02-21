package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommodityStatus {
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

    CommodityStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
    public static CommodityStatus getEnums(String code) {
        for (CommodityStatus enums : values()) {
            if (code.equalsIgnoreCase(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
