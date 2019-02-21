package com.sptwin.xy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserClient {
    private Long id;

    @ApiModelProperty("代理ID，类似：1,2,3")
    private String agentIds;

    @ApiModelProperty("分组ID，类似：1,2,3")
    private String groupIds;

    @ApiModelProperty("用户ID")
    private Integer userId;
}