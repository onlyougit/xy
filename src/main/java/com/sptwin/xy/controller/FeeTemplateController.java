package com.sptwin.xy.controller;

import com.sptwin.xy.entity.FeeTemplateCommodity;
import com.sptwin.xy.pojo.FeeTemplateCustom;
import com.sptwin.xy.service.FeeTemplateService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "手续费、保证金模版相关的接口API")
@RestController
public class FeeTemplateController {

    @Autowired
    private FeeTemplateService feeTemplateService;

    @GetMapping("/feeTemplate/query/page")
    @ApiOperation("查询模版信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "类型（0:保证金模版；1:手续费模版）",required = true,defaultValue = "0",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageIndex",value = "第几页（从0开始）",required = true,defaultValue = "0",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据", required = true,dataType = "int",paramType = "query")
    })
    public ResponseBase queryFeeTemplatePage(
            @RequestParam("type") Integer type,
            @RequestParam("pageIndex") Integer pageIndex,
            @RequestParam("pageSize") Integer pageSize){

        ResponseBase responseBase = feeTemplateService.queryFeeTemplatePage(type, pageIndex, pageSize);
        return responseBase;
    }
    @GetMapping("/feeTemplate/commodity／query/page")
    @ApiOperation("查询品种模版信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feeTemplateId",value = "保证金模版ID",required = true,dataType = "long",paramType = "query"),
            @ApiImplicitParam(name = "pageIndex",value = "第几页（从0开始）",required = true,defaultValue = "0",dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页几条数据", required = true,dataType = "int",paramType = "query")
    })
    public ResponseBase queryFeeTemplateCommodityPage(
            @RequestParam("feeTemplateId")  Integer feeTemplateId,
            @RequestParam("pageIndex")  Integer pageIndex,
            @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = feeTemplateService.queryFeeTemplateCommodityPage(feeTemplateId,pageIndex,pageSize);
        return responseBase;
    }

    @ApiOperation("添加模版信息")
    @ApiImplicitParam(name = "feeTemplateCustom", value = "模版扩展实体", required = true, dataType = "FeeTemplateCustom")
    @PostMapping("/feeTemplate/add")
    public ResponseBase addFeeTemplate(@RequestBody FeeTemplateCustom feeTemplateCustom) {
        ResponseBase responseBase = feeTemplateService.addFeeTemplate(feeTemplateCustom);
        return responseBase;
    }

    @ApiOperation("更新查询品种模版信息")
    @ApiImplicitParam(name = "id", value = "品种模版ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/feeTemplate/update/query/{id}")
    public ResponseBase updateQueryFeeTemplate(@PathVariable Long id){
        ResponseBase responseBase = feeTemplateService.updateQueryFeeTemplate(id);
        return responseBase;
    }
    @ApiOperation("更新品种模版信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "feeTemplateCommodity", value = "品种模版实体", dataType = "FeeTemplateCommodity"),
            @ApiImplicitParam(name = "id", value = "品种模版ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/feeTemplate/update/{id}")
    public ResponseBase updateFeeTemplate(@PathVariable Long id, @RequestBody FeeTemplateCommodity feeTemplateCommodity) {
        feeTemplateCommodity.setId(id);
        ResponseBase responseBase = feeTemplateService.updateFeeTemplate(feeTemplateCommodity);
        return responseBase;
    }

    @ApiOperation("删除模版信息")
    @ApiImplicitParam(name = "id", value = "模版ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/feeTemplate/delete/{id}")
    public ResponseBase deleteFeeTemplate(@PathVariable Integer id){
        ResponseBase responseBase = feeTemplateService.deleteFeeTemplate(id);
        return responseBase;
    }
}
