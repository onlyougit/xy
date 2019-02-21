package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OutInMode {
    BACKEND(0, "后台人工"),

    WEB(1, "网页自动"),;
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

    OutInMode(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static OutInMode getEnums(Integer code) {
        for (OutInMode enums : values()) {
            if (code == enums.getCode()) {
                return enums;
            }
        }
        return null;
    }
}
