package com.sptwin.xy.controller;

import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.service.SysPermissionService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "权限相关的接口API")
@RestController
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/permission/query/page")
    @ApiOperation("根据条件查询权限信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryPermissionPage(@RequestParam("pageIndex")  Integer pageIndex,
                                          @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = sysPermissionService.queryPermissionPage(pageIndex,pageSize);
        return responseBase;
    }
    @ApiOperation("添加权限信息")
    @ApiImplicitParam(name = "sysPermission", value = "权限实体", required = true, dataType = "SysPermission")
    @PostMapping("/permission/add")
    public ResponseBase addPermission(@RequestBody SysPermission sysPermission){
        ResponseBase responseBase = sysPermissionService.addPermission(sysPermission);
        return responseBase;
    }
    @ApiOperation("更新查询权限信息")
    @ApiImplicitParam(name = "id", value = "权限ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/permission/update/query/{id}")
    public ResponseBase updatePermissionQuery(@PathVariable Integer id){
        ResponseBase responseBase = sysPermissionService.updatePermissionQuery(id);
        return responseBase;
    }
    @ApiOperation("更新权限信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPermission", value = "权限实体", dataType = "SysPermission"),
            @ApiImplicitParam(name = "id", value = "权限ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping("/permission/update/{id}")
    public ResponseBase updatePermission(@PathVariable Integer id, @RequestBody SysPermission sysPermission){
        sysPermission.setId(id);
        ResponseBase responseBase = sysPermissionService.updatePermission(sysPermission);
        return responseBase;
    }
    @ApiOperation("删除权限信息")
    @ApiImplicitParam(name = "id", value = "权限ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/permission/delete/{id}")
    public ResponseBase deletePermission(@PathVariable Integer id) {
        ResponseBase responseBase = sysPermissionService.deletePermission(id);
        return responseBase;
    }

}
