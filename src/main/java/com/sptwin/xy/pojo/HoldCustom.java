package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Hold;
import com.sptwin.xy.enums.Direct;
import lombok.Data;

import java.util.Date;

@Data
public class HoldCustom extends Hold {

    private Direct directEnum;

    private Date createTime;
}
