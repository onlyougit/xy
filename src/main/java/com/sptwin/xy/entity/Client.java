package com.sptwin.xy.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Client {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("代理ID")
    private Long clientAgentId;

    @ApiModelProperty("客户组ID")
    private Long clientGroupId;

    @ApiModelProperty("客户编号")
    private String clientNo;

    @ApiModelProperty("客户名称")
    private String clientName;

    @ApiModelProperty("密码")
    private String clientPassword;

    @ApiModelProperty("电话")
    private String clientPhone;

    @ApiModelProperty("身份证")
    private String clientIdNo;

    @ApiModelProperty("注册时间")
    private Date clientRegistDate;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("加盐加密")
    private String salt;
}