package com.sptwin.xy.controller;

import com.sptwin.xy.entity.Client;
import com.sptwin.xy.entity.ClientRateRelation;
import com.sptwin.xy.pojo.ClientCustom;
import com.sptwin.xy.service.ClientService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "客户相关的接口API")
public class ClientController{

    @Autowired
    private ClientService clientService;

    //@RequiresPermissions("client:view")
    @PostMapping("/client/query/page")
    @ApiOperation("根据条件查询客户信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientCustom", value = "客户扩展实体", dataType = "ClientCustom"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryClientPage(@RequestBody ClientCustom clientCustom,
                                        @RequestParam("pageIndex")  Integer pageIndex,
                                        @RequestParam("pageSize")  Integer pageSize){

        ResponseBase responseBase = clientService.queryClientPage(clientCustom, pageIndex, pageSize);
        return responseBase;
    }

    @ApiOperation("查询某个客户代理下面的客户信息")
    @ApiImplicitParam(name = "agentId", value = "客户代理ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/client/query/agent/{agentId}")
    public ResponseBase queryClientByAgentId(@PathVariable Long agentId){
        ResponseBase responseBase = clientService.queryClientByAgentId(agentId);
        return responseBase;
    }
    @ApiOperation("查询某个客户分组下面的客户信息")
    @ApiImplicitParam(name = "groupId", value = "客户分组ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/client/query/group/{groupId}")
    public ResponseBase queryClientByGroupId(@PathVariable Long groupId){
        ResponseBase responseBase = clientService.queryClientByGroupId(groupId);
        return responseBase;
    }
    @PostMapping("/login")
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientNo", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    public ResponseBase login(String clientNo, String password){

        ResponseBase responseBase = clientService.login(clientNo, password);
        return responseBase;
    }
    @ApiOperation("添加客户模版信息")
    @ApiImplicitParam(name = "clientRateRelation", value = "客户模版实体", required = true, dataType = "ClientRateRelation")
    @PostMapping("/clientRateRelation/add")
    public ResponseBase addClientRateRelation(@RequestBody ClientRateRelation clientRateRelation){
        ResponseBase responseBase = clientService.addClientRateRelation(clientRateRelation);
        return responseBase;
    }
    @ApiOperation("添加客户信息")
    @ApiImplicitParam(name = "client", value = "客户实体", required = true, dataType = "Client")
    @PostMapping("/client/add")
    public ResponseBase addClient(@RequestBody Client client){
        ResponseBase responseBase = clientService.addClient(client);
        return responseBase;
    }
    @ApiOperation("更新查询客户信息")
    @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/client/update/query/{id}")
    public ResponseBase updateQueryClient(@PathVariable Long id){
        ResponseBase responseBase = clientService.updateQueryClient(id);
        return responseBase;
    }
    @ApiOperation("更新客户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client", value = "客户实体", dataType = "Client"),
            @ApiImplicitParam(name = "id", value = "客户ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/client/update/{id}")
    public ResponseBase updateClient(@PathVariable Long id, @RequestBody Client client){
        client.setId(id);
        ResponseBase responseBase = clientService.updateClient(client);
        return responseBase;
    }
}
