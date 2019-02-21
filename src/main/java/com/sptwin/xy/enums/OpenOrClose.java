package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OpenOrClose {
    A(0, "开仓"),
    B(1, "平仓"),

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
	OpenOrClose(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static OpenOrClose getEnums(Integer code) {
        for (OpenOrClose enums : values()) {
            if (code.equals(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
