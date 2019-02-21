package com.sptwin.xy.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatus {
    A(0, "指令失败"),
    B(1, "排队"),
    C(2, "部分成交"),
    D(3, "完全成交"),
    E(4, "部分撤单"),
    F(5, "全部撤单"),
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
	OrderStatus(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
    public Integer getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static OrderStatus getEnums(Integer code) {
        for (OrderStatus enums : values()) {
            if (code.equals(enums.getCode())) {
                return enums;
            }
        }
        return null;
    }
}
