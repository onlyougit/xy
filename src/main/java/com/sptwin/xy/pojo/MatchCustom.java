package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Match;
import com.sptwin.xy.enums.Direct;
import com.sptwin.xy.enums.OpenOrClose;
import lombok.Data;

import java.util.Date;

@Data
public class MatchCustom extends Match {

    private Direct directEnum;

    private OpenOrClose openOrCloseEnum;

    private Date createTime;
}
