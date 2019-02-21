package com.sptwin.xy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Exchange {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("市场编号")
    private String exchangeNo;

    @ApiModelProperty("市场名称")
    private String exchangeName;

    @ApiModelProperty("市场状态")
    private String status;
}