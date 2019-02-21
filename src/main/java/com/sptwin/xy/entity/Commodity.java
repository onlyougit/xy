package com.sptwin.xy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Commodity {
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("市场编号")
    private String exchangeNo;

    @ApiModelProperty("货币编号")
    private String currencyNo;

    @ApiModelProperty("品种编号")
    private String commodityNo;

    @ApiModelProperty("品种名称")
    private String commodityName;

    @ApiModelProperty("最小单位")
    private BigDecimal minTick;

    @ApiModelProperty("最小单位价值")
    private BigDecimal minTickPrice;

    @ApiModelProperty("单笔下单最大量")
    private Integer maxSingleOrderVol;

    @ApiModelProperty("最大持仓量")
    private Integer maxHolVol;

    @ApiModelProperty("状态")
    private String status;
}