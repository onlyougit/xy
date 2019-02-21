package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserStatus {
    /* 无效 */
    N(0, "无效"),
    /* 有效 */
    Y(1, "有效"),

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
	UserStatus(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static UserStatus getEnums(Integer code) {
        for (UserStatus enums : values()) {
            if (code.equals(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
