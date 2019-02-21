package com.sptwin.xy.controller;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.service.ClientAgentService;
import com.sptwin.xy.service.ClientService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(description = "客户代理相关的接口API")
public class ClientAgentController extends BaseApiService {

    @Autowired
    @Qualifier("clientServiceA")
    private ClientAgentService clientAgentService;
    @Resource(name="clientServiceA")
    ClientService clientService;

    @ApiOperation("添加客户代理信息")
    @ApiImplicitParam(name = "clientAgent", value = "客户代理实体", required = true, dataType = "ClientAgent")
    @PostMapping("/clientAgent/add")
    public ResponseBase addClientAgent(@RequestBody ClientAgent clientAgent){
        ResponseBase responseBase = clientAgentService.addClientAgent(clientAgent);
        return responseBase;
    }

    @ApiOperation("更新查询客户代理信息")
    @ApiImplicitParam(name = "id", value = "客户代理ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/clientAgent/update/query/{id}")
    public ResponseBase updateQueryClientAgent(@PathVariable Long id){
        ResponseBase responseBase = clientAgentService.updateQueryClientAgent(id);
        return responseBase;
    }
    @ApiOperation("更新客户代理信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clientAgent", value = "客户代理实体", dataType = "ClientAgent"),
            @ApiImplicitParam(name = "id", value = "客户代理ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/clientAgent/update/{id}")
    public ResponseBase updateClientAgent(@PathVariable Long id, @RequestBody ClientAgent clientAgent){
        clientAgent.setId(id);
        ResponseBase responseBase = clientAgentService.updateClientAgent(clientAgent);
        return responseBase;
    }

    @ApiOperation("删除客户代理信息")
    @ApiImplicitParam(name = "id", value = "客户代理ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/clientAgent/delete/{id}")
    public ResponseBase deleteClientAgent(@PathVariable Long id){
        ResponseBase responseBase = clientAgentService.deleteClientAgent(id);
        return responseBase;
    }
}
