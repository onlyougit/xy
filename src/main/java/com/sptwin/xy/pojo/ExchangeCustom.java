package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Exchange;
import com.sptwin.xy.enums.ExchangeStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExchangeCustom extends Exchange {
    @ApiModelProperty("市场状态枚")
    private ExchangeStatus exchangeStatusEnum;
}
