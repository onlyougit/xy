package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ContractType {
    ORDINARY(0, "普通合约"),

    MAIN(1, "主力合约"),;
    /* 编码 */
    private Integer code;

    /* 描述 */
    private String text;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    ContractType(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static ContractType getEnums(Integer code) {
        for (ContractType enums : values()) {
            if (code == enums.getCode()) {
                return enums;
            }
        }
        return null;
    }
}
