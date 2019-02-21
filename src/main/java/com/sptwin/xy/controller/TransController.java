package com.sptwin.xy.controller;

import com.sptwin.xy.service.TransService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(description = "交易相关的接口API")
public class TransController {

    @Autowired
    private TransService transService;

    @PostMapping("/trans/order/query")
    @ApiOperation("根据条件查询委托信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryOrder(@RequestParam(value = "clientNo", required = false) String clientNo){
        ResponseBase responseBase = transService.queryOrder(clientNo);
        return responseBase;
    }

    @PostMapping("/trans/history/order/query/page")
    @ApiOperation("根据条件查询历史委托信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryOrderHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                   @RequestParam(value = "endDate", required = false) Date endDate,
                                                   @RequestParam(value = "clientNo", required = false) String clientNo,
                                                   @RequestParam("pageIndex")  Integer pageIndex,
                                                   @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = transService.queryOrderHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }
    @PostMapping("/trans/match/query")
    @ApiOperation("根据条件查询成交信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryMatch(@RequestParam(value = "clientNo", required = false) String clientNo){

        ResponseBase responseBase = transService.queryMatch(clientNo);
        return responseBase;
    }
    @PostMapping("/trans/history/match/query/page")
    @ApiOperation("根据条件查询历史成交信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryMatchHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                  @RequestParam(value = "endDate", required = false) Date endDate,
                                                  @RequestParam(value = "clientNo", required = false) String clientNo,
                                                  @RequestParam("pageIndex")  Integer pageIndex,
                                                  @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = transService.queryMatchHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }
    @PostMapping("/trans/hold/query")
    @ApiOperation("根据条件查询持仓信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryHold(@RequestParam(value = "clientNo", required = false) String clientNo){

        ResponseBase responseBase = transService.queryHold(clientNo);
        return responseBase;
    }
    @PostMapping("/trans/history/hold/query/page")
    @ApiOperation("根据条件查询历史持仓信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryHoldHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                   @RequestParam(value = "endDate", required = false) Date endDate,
                                                   @RequestParam(value = "clientNo", required = false) String clientNo,
                                                   @RequestParam("pageIndex")  Integer pageIndex,
                                                   @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = transService.queryHoldHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }
}
