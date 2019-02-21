package com.sptwin.xy.controller;

import com.sptwin.xy.entity.Exchange;
import com.sptwin.xy.service.ExchangeService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "市场相关的接口API")
@RestController
public class ExchangeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping("/exchange/query/page")
    @ApiOperation("根据条件查询市场信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex",value = "第几页（从0开始）",required = true,defaultValue = "0",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据", required = true,dataType = "int",paramType = "query")
    })
    public ResponseBase queryExchangePage(@RequestParam("pageIndex")  Integer pageIndex,
                                          @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = exchangeService.queryExchangePage(pageIndex,pageSize);
        return responseBase;
    }
    @ApiOperation("添加市场信息")
    @ApiImplicitParam(name = "exchange", value = "市场实体", required = true, dataType = "Exchange")
    @PostMapping("/exchange/add")
    public ResponseBase addExchange(@RequestBody Exchange exchange){
        ResponseBase responseBase = exchangeService.addExchange(exchange);
        return responseBase;
    }

    @ApiOperation("更新查询市场信息")
    @ApiImplicitParam(name = "id", value = "市场ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/exchange/update/query/{id}")
    public ResponseBase updateQueryExchange(@PathVariable Long id){
        ResponseBase responseBase = exchangeService.updateQueryExchange(id);
        return responseBase;
    }
    @ApiOperation("更新市场信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "exchange",value = "市场实体", dataType = "Exchange"),
            @ApiImplicitParam(name = "id", value = "市场ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/exchange/update/{id}")
    public ResponseBase updateExchange(@PathVariable Long id, @RequestBody Exchange exchange){
        exchange.setId(id);
        ResponseBase responseBase = exchangeService.updateExchange(exchange);
        return responseBase;
    }

    @ApiOperation("删除市场信息")
    @ApiImplicitParam(name = "id", value = "市场ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/exchange/delete/{id}")
    public ResponseBase deleteExchange(@PathVariable Long id){
        ResponseBase responseBase = exchangeService.deleteExchange(id);
        return responseBase;
    }
}
