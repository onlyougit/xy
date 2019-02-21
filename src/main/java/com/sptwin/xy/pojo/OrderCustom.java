package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Order;
import com.sptwin.xy.enums.*;
import lombok.Data;

import java.util.Date;

@Data
public class OrderCustom extends Order {
    private OrderType orderTypeEnum;

    private OrderStatus orderStatusEnum;

    private RiskOrder riskOrderEnum;

    private Direct directEnum;

    private OpenOrClose openOrCloseEnum;

    private Date createTime;
}
