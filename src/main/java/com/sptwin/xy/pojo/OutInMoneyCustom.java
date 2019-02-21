package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.OutInMoney;
import com.sptwin.xy.enums.OutInMode;
import lombok.Data;

@Data
public class OutInMoneyCustom extends OutInMoney{
    private OutInMode outInModeEnum;
}
