package com.sptwin.xy.controller;

import com.sptwin.xy.entity.Commodity;
import com.sptwin.xy.pojo.CommodityCustom;
import com.sptwin.xy.service.CommodityService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "品种相关的接口API")
@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @PostMapping("/commodity/query")
    @ApiOperation("根据条件查询品种信息列表")
    @ApiImplicitParam(name = "commodity", value = "品种实体", dataType = "Commodity")
    public ResponseBase queryCommodity(@RequestBody Commodity commodity) {
        ResponseBase responseBase = commodityService.queryCommodity(commodity);
        return responseBase;
    }

    @PostMapping("/commodity/query/page")
    @ApiOperation("根据条件查询品种信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodityCustom", value = "货币扩展实体", dataType = "CommodityCustom"),
            @ApiImplicitParam(name = "pageIndex",value = "第几页（从0开始）",required = true,defaultValue = "0",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据", required = true,dataType = "int",paramType = "query")
    })
    public ResponseBase queryCommodityPage(@RequestBody CommodityCustom commodityCustom,
                                           @RequestParam  Integer pageIndex,
                                           @RequestParam  Integer pageSize){

        ResponseBase responseBase = commodityService.queryCommodityPage(commodityCustom, pageIndex, pageSize);
        return responseBase;
    }

    @ApiOperation("添加品种信息")
    @ApiImplicitParam(name = "commodity", value = "品种实体", required = true, dataType = "Commodity")
    @PostMapping("/commodity/add")
    public ResponseBase addCommodity(@RequestBody Commodity commodity){
        ResponseBase responseBase = commodityService.addCommodity(commodity);
        return responseBase;
    }

    @ApiOperation("更新查询品种信息")
    @ApiImplicitParam(name = "id", value = "品种ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/commodity/update/query/{id}")
    public ResponseBase updateQueryCommodity(@PathVariable Long id){
        ResponseBase responseBase = commodityService.updateQueryCommodity(id);
        return responseBase;
    }
    @ApiOperation("更新品种信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commodity",value = "品种实体", dataType = "Commodity"),
            @ApiImplicitParam(name = "id", value = "品种ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/commodity/update/{id}")
    public ResponseBase updateCommodity(@PathVariable Long id, @RequestBody Commodity commodity){
        commodity.setId(id);
        ResponseBase responseBase = commodityService.updateCommodity(commodity);
        return responseBase;
    }

    @ApiOperation("删除品种信息")
    @ApiImplicitParam(name = "id", value = "品种ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/commodity/delete/{id}")
    public ResponseBase deleteCommodity(@PathVariable Long id){
        ResponseBase responseBase = commodityService.deleteCommodity(id);
        return responseBase;
    }

}
