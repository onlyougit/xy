package com.sptwin.xy.controller;

import com.sptwin.xy.entity.Currency;
import com.sptwin.xy.service.CurrencyService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "货币相关的接口API")
@RestController
public class CurrencyController{
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency/query/page")
    @ApiOperation("根据条件查询货币信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryCurrencyPage(@RequestParam("pageIndex")  Integer pageIndex,
                                          @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = currencyService.queryCurrencyPage(pageIndex,pageSize);
        return responseBase;
    }
    @ApiOperation("添加货币信息")
    @ApiImplicitParam(name = "currency", value = "货币实体", required = true, dataType = "Currency")
    @PostMapping("/currency/add")
    public ResponseBase addCurrency(@RequestBody Currency currency){
        ResponseBase responseBase = currencyService.addCurrency(currency);
        return responseBase;
    }

    @ApiOperation("更新查询货币信息")
    @ApiImplicitParam(name = "id", value = "货币ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/currency/update/query/{id}")
    public ResponseBase updateQueryCurrency(@PathVariable Long id){
        ResponseBase responseBase = currencyService.updateQueryCurrency(id);
        return responseBase;
    }
    @ApiOperation("更新货币信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currency", value = "货币实体", dataType = "Currency"),
            @ApiImplicitParam(name = "id", value = "货币ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/currency/update/{id}")
    public ResponseBase updateCurrency(@PathVariable Long id, @RequestBody Currency currency){
        currency.setId(id);
        ResponseBase responseBase = currencyService.updateCurrency(currency);
        return responseBase;
    }
}
