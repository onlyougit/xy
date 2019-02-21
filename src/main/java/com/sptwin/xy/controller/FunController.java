package com.sptwin.xy.controller;

import com.sptwin.xy.entity.CreditMoney;
import com.sptwin.xy.entity.OutInMoney;
import com.sptwin.xy.service.FundService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Api(description = "资金相关的接口API")
public class FunController{

    @Autowired
    private FundService fundService;

    @PostMapping("/fund/query")
    @ApiOperation("根据条件查询资金信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryFund(@RequestParam(value = "clientNo", required = false) String clientNo){
        ResponseBase responseBase = fundService.queryFund(clientNo);
        return responseBase;
    }

    @PostMapping("/fund/history/query/page")
    @ApiOperation("根据条件查询历史资金信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryFundHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                   @RequestParam(value = "endDate", required = false) Date endDate,
                                                   @RequestParam(value = "clientNo", required = false) String clientNo,
                                                   @RequestParam("pageIndex")  Integer pageIndex,
                                                   @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = fundService.queryFundHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }
    @PostMapping("/fund/out/in/query")
    @ApiOperation("根据条件查询出入金信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryFundOutIn(@RequestParam(value = "clientNo", required = false) String clientNo){

        ResponseBase responseBase = fundService.queryFundOutIn(clientNo);
        return responseBase;
    }
    @PostMapping("/fund/out/in/history/query/page")
    @ApiOperation("根据条件查询历史出入金信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "date", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryFundOutInHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                  @RequestParam(value = "endDate", required = false) Date endDate,
                                                  @RequestParam(value = "clientNo", required = false) String clientNo,
                                                  @RequestParam("pageIndex")  Integer pageIndex,
                                                  @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = fundService.queryFundOutInHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }
    @PostMapping("/fund/credit/query")
    @ApiOperation("根据条件查询授信资金信息列表")
    @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query")
    public ResponseBase queryFundCredit(@RequestParam(value = "clientNo", required = false) String clientNo){

        ResponseBase responseBase = fundService.queryFundCredit(clientNo);
        return responseBase;
    }
    @PostMapping("/fund/credit/history/query/page")
    @ApiOperation("根据条件查询历史授信资金信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "起始日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束日期", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "clientNo", value = "客户编号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryFundCreditHistoryPage(@RequestParam(value = "startDate", required = false) Date startDate,
                                                   @RequestParam(value = "endDate", required = false) Date endDate,
                                                   @RequestParam(value = "clientNo", required = false) String clientNo,
                                                   @RequestParam("pageIndex")  Integer pageIndex,
                                                   @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = fundService.queryFundCreditHistoryPage(startDate, endDate, clientNo, pageIndex, pageSize);
        return responseBase;
    }

    @ApiOperation("添加出入金信息")
    @ApiImplicitParam(name = "outInMoney", value = "出入金实体", required = true, dataType = "OutInMoney")
    @PostMapping("/fund/out/in/add")
    public ResponseBase addOutInMoney(@RequestBody OutInMoney outInMoney) {
        ResponseBase responseBase = fundService.addOutInMoney(outInMoney);
        return responseBase;
    }
    @ApiOperation("添加授信资金信息")
    @ApiImplicitParam(name = "creditMoney", value = "授信资金实体", required = true, dataType = "CreditMoney")
    @PostMapping("/fund/credit/add")
    public ResponseBase addCreditMoney(@RequestBody CreditMoney creditMoney) {
        ResponseBase responseBase = fundService.addCreditMoney(creditMoney);
        return responseBase;
    }
}
