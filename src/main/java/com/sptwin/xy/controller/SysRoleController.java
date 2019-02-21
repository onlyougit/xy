package com.sptwin.xy.controller;

import com.sptwin.xy.entity.SysRole;
import com.sptwin.xy.service.SysRoleService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "角色相关的接口API")
@RestController
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/role/query/page")
    @ApiOperation("根据条件查询角色信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryRolePage(@RequestParam("pageIndex")  Integer pageIndex,
                                          @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = sysRoleService.queryRolePage(pageIndex,pageSize);
        return responseBase;
    }
    @ApiOperation("添加角色信息")
    @ApiImplicitParam(name = "sysRole", value = "角色实体", required = true, dataType = "SysRole")
    @PostMapping("/role/add")
    public ResponseBase addRole(@RequestBody SysRole sysRole){
        ResponseBase responseBase = sysRoleService.addRole(sysRole);
        return responseBase;
    }
    @ApiOperation("更新查询角色信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/role/update/query/{id}")
    public ResponseBase updateRoleQuery(@PathVariable Integer id){
        ResponseBase responseBase = sysRoleService.updateRoleQuery(id);
        return responseBase;
    }
    @ApiOperation("更新角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRole", value = "角色实体", dataType = "SysRole"),
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping("/role/update/{id}")
    public ResponseBase updateRole(@PathVariable Integer id, @RequestBody SysRole sysRole){
        sysRole.setId(id);
        ResponseBase responseBase = sysRoleService.updateRole(sysRole);
        return responseBase;
    }
    @ApiOperation("删除角色信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/role/delete/{id}")
    public ResponseBase deleteRole(@PathVariable Integer id) {
        ResponseBase responseBase = sysRoleService.deleteRole(id);
        return responseBase;
    }

}
