package com.sptwin.xy.controller;

import com.sptwin.xy.entity.ClientGroup;
import com.sptwin.xy.service.ClientGroupService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "客户分组相关的接口API")
public class ClientGroupController extends BaseApiService {

    @Autowired
    private ClientGroupService clientGroupService;

    @ApiOperation("根据代理查询客户分组信息")
    @ApiImplicitParam(name = "clientAgentId", value = "客户代理ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/clientGroup/query/{clientAgentId}")
    public ResponseBase queryClientGroupByClientAgentId(@PathVariable Long clientAgentId){
        ResponseBase responseBase = clientGroupService.queryClientGroupByClientAgentId(clientAgentId);
        return responseBase;
    }
    @ApiOperation("添加客户分组信息")
    @ApiImplicitParam(name = "clientGroup", value = "客户分组实体", required = true, dataType = "ClientGroup")
    @PostMapping("/clientGroup/add")
    public ResponseBase addClientGroup(@RequestBody ClientGroup clientGroup){
        ResponseBase responseBase = clientGroupService.addClientGroup(clientGroup);
        return responseBase;
    }

    @ApiOperation("更新查询客户分组信息")
    @ApiImplicitParam(name = "id", value = "客户分组ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/clientGroup/update/query/{id}")
    public ResponseBase updateQueryClientGroup(@PathVariable Long id){
        ResponseBase responseBase = clientGroupService.updateQueryClientGroup(id);
        return responseBase;
    }
    @ApiOperation("更新客户分组信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientGroup", value = "客户分组实体", dataType = "ClientGroup"),
            @ApiImplicitParam(name = "id", value = "客户分组ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/clientGroup/update/{id}")
    public ResponseBase updateClientGroup(@PathVariable Long id, @RequestBody ClientGroup clientGroup){
        clientGroup.setId(id);
        ResponseBase responseBase = clientGroupService.updateClientGroup(clientGroup);
        return responseBase;
    }

    @ApiOperation("删除客户分组信息")
    @ApiImplicitParam(name = "id", value = "客户分组ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/clientGroup/delete/{id}")
    public ResponseBase deleteClientGroup(@PathVariable Long id){
        ResponseBase responseBase = clientGroupService.deleteClientGroup(id);
        return responseBase;
    }
}
