package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Direct {
    A(0, "卖出"),
    B(1, "买入"),

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
	Direct(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static Direct getEnums(Integer code) {
        for (Direct enums : values()) {
            if (code.equals(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
