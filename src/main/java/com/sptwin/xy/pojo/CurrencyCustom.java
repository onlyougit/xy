package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Currency;
import com.sptwin.xy.enums.CurrencyStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CurrencyCustom extends Currency {
    @ApiModelProperty(value="货币状态枚举")
    private CurrencyStatus currencyStatusEnum;

}
