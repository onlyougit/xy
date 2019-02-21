package com.sptwin.xy.controller;

import com.sptwin.xy.entity.SysUserClient;
import com.sptwin.xy.pojo.SysUserCustom;
import com.sptwin.xy.service.SysUserService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "用户相关的接口API")
@RestController
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/user/query/page")
    @ApiOperation("根据条件查询用户信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryUserPage(@RequestParam("pageIndex")  Integer pageIndex,
                                          @RequestParam("pageSize")  Integer pageSize){
        ResponseBase responseBase = sysUserService.queryUserPage(pageIndex,pageSize);
        return responseBase;
    }
    @GetMapping("/user/client/query/{userId}")
    @ApiOperation("根据用户ID查询分配和未分配的代理")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    public ResponseBase queryUserClient(@PathVariable Integer userId){
        ResponseBase responseBase = sysUserService.queryUserClient(userId);
        return responseBase;
    }
    @ApiOperation("给用户分配客户")
    @ApiImplicitParam(name = "sysUserClient", value = "用户客户实体", required = true, dataType = "SysUserClient")
    @PostMapping("/user/client/add")
    public ResponseBase addUserClient(@RequestBody SysUserClient sysUserClient){
        ResponseBase responseBase = sysUserService.addUserClient(sysUserClient);
        return responseBase;
    }

    @ApiOperation("更新用户代理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUserClient", value = "用户代理实体", dataType = "SysUserClient"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping("/user/client/update/{userId}")
    public ResponseBase updateUserClient(@PathVariable Integer userId, @RequestBody SysUserClient sysUserClient){
        sysUserClient.setUserId(userId);
        ResponseBase responseBase = sysUserService.updateUserClient(sysUserClient);
        return responseBase;
    }
    @ApiOperation("添加用户信息")
    @ApiImplicitParam(name = "sysUserCustom", value = "用户扩展实体", required = true, dataType = "SysUserCustom")
    @PostMapping("/user/add")
    public ResponseBase addUser(@RequestBody SysUserCustom sysUserCustom){
        ResponseBase responseBase = sysUserService.addUser(sysUserCustom);
        return responseBase;
    }
    @ApiOperation("更新查询用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/user/update/query/{id}")
    public ResponseBase updateQueryUser(@PathVariable Integer id){
        ResponseBase responseBase = sysUserService.updateQueryUser(id);
        return responseBase;
    }
    @ApiOperation("更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysUserCustom", value = "用户扩展实体", dataType = "SysUserCustom"),
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    })
    @PutMapping("/user/update/{id}")
    public ResponseBase updateUser(@PathVariable Integer id, @RequestBody SysUserCustom sysUserCustom){
        sysUserCustom.setId(id);
        ResponseBase responseBase = sysUserService.updateUser(sysUserCustom);
        return responseBase;
    }
    @ApiOperation("删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    @DeleteMapping("/user/delete/{id}")
    public ResponseBase deleteUser(@PathVariable Integer id) {
        ResponseBase responseBase = sysUserService.deleteUser(id);
        return responseBase;
    }

    @GetMapping("/user/query/left/menu")
    @ApiOperation("登录后，查询左边菜单")
    public ResponseBase queryLeftMenu(){
        ResponseBase responseBase = sysUserService.queryLeftMenu();
        return responseBase;
    }

}
