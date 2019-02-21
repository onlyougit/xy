package com.sptwin.xy.controller;

import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.service.ContractService;
import com.sptwin.xy.utils.ResponseBase;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "合约相关的接口API")
@RestController
public class ContractController {

    @Autowired
    private ContractService contractService;

    @PostMapping("/contract/query")
    @ApiOperation("根据条件查询合约信息列表")
    @ApiImplicitParam(name = "contract", value = "合约实体", dataType = "Contract")
    public ResponseBase queryContract(@RequestBody Contract contract) {
        ResponseBase responseBase = contractService.queryContract(contract);
        return responseBase;
    }

    @GetMapping("/contract/query/page")
    @ApiOperation("根据条件查询合约或主力合约信息列表（分页）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "是不是主力合约", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageIndex", value = "第几页（从0开始）", required = true, defaultValue = "0", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页几条数据", required = true, dataType = "int", paramType = "query")
    })
    public ResponseBase queryContractPage(Integer type, Integer pageIndex, Integer pageSize) {
        ResponseBase responseBase = contractService.queryContractPage(type, pageIndex, pageSize);
        return responseBase;
    }

    @ApiOperation("添加主力合约信息")
    @PostMapping("/contract/main/add")
    public ResponseBase addMainContract(@RequestParam(value = "idList") @ApiParam(value = "合约id列表", required = true) List<Long> idList) {
        ResponseBase responseBase = contractService.addMainContract(idList);
        return responseBase;
    }

    @ApiOperation("添加合约信息")
    @ApiImplicitParam(name = "contract", value = "合约实体", required = true, dataType = "Contract")
    @PostMapping("/contract/add")
    public ResponseBase addContract(@RequestBody Contract contract) {
        ResponseBase responseBase = contractService.addContract(contract);
        return responseBase;
    }

    @ApiOperation("更新查询合约信息")
    @ApiImplicitParam(name = "id", value = "合约ID", required = true, dataType = "int", paramType = "path")
    @GetMapping("/contract/update/query/{id}")
    public ResponseBase updateQueryContract(@PathVariable Long id){
        ResponseBase responseBase = contractService.updateQueryContract(id);
        return responseBase;
    }
    @ApiOperation("更新合约信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contract", value = "合约实体", dataType = "Contract"),
            @ApiImplicitParam(name = "id", value = "合约ID", required = true, dataType = "Long", paramType = "path")
    })
    @PutMapping("/contract/update/{id}")
    public ResponseBase updateContract(@PathVariable Long id, @RequestBody Contract contract) {
        contract.setId(id);
        ResponseBase responseBase = contractService.updateContract(contract);
        return responseBase;
    }

    @ApiOperation("删除合约信息")
    @ApiImplicitParam(name = "id", value = "合约ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/contract/delete/{id}")
    public ResponseBase deleteContract(@PathVariable Long id) {
        ResponseBase responseBase = contractService.deleteContract(id);
        return responseBase;
    }

    @ApiOperation("删除主力合约信息")
    @ApiImplicitParam(name = "id", value = "合约ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/contract/main/delete/{id}")
    public ResponseBase deleteMainContract(@PathVariable Long id) {
        ResponseBase responseBase = contractService.deleteMainContract(id);
        return responseBase;
    }
}
