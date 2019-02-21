package com.sptwin.xy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.mapper.ContractCustomMapper;
import com.sptwin.xy.mapper.ContractMapper;
import com.sptwin.xy.pojo.ContractCustom;
import com.sptwin.xy.service.ContractService;
import com.sptwin.xy.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("contractService")
public class ContractServiceImpl extends BaseApiService implements ContractService {
    Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);

    @Value("${contract.file-path}")
    private String filePath;
    @Autowired
    private ContractCustomMapper contractCustomMapper;
    @Autowired
    private ContractMapper contractMapper;

    @Override
    public ResponseBase queryContractPage(Integer type, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<ContractCustom> contractCustoms = contractCustomMapper.queryContractPage(type);
        PageBean<ContractCustom> pb = new PageBean(contractCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addContract(Contract contract) {
        //判断编号唯一
        int result = contractCustomMapper.queryByNoAndCommodityNo(contract.getContractNo(),contract.getCommodityNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        contract.setMainContract(0);
        int count = contractMapper.insertSelective(contract);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateContract(Contract contract) {
        int count = contractMapper.updateByPrimaryKeySelective(contract);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase deleteContract(Long id) {
        //当委托信息、成交信息、持仓信息表中无关联这条记录时可以删除
        int count = contractMapper.deleteByPrimaryKey(id);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.DELETE_FAILED);
        }
    }

    @Override
    public ResponseBase queryContract(Contract contract) {
        List<ContractCustom> contractCustoms = contractCustomMapper.queryContract(contract);
        return setResultSuccess(contractCustoms);
    }

    @Transactional
    @Override
    public ResponseBase addMainContract(List<Long> idList) {
        //List<Long> list = JSONArray.parseArray(ids, Long.class);
        //根据ID批量查询合约信息
        List<Contract> contractList = contractCustomMapper.batchQueryContract(idList);
        //批量更新合约类型为主力合约
        contractCustomMapper.batchUpdateContract(idList);
        //添加到配置文件
        //先查询配置文件所有主力合约
        String json = FileUtil.readJson(filePath);
        String json2 = null;
        if(null == json){
            json2 = JSON.toJSONString(contractList);

        }else{
            List<Contract> contracts = JSON.parseArray(json,Contract.class);
            contracts.addAll(contractList);
            json2 = JSON.toJSONString(contracts);

        }
        String jsonFormat = JsonFormatTool.formatJson(json2);
        FileUtil.writeJson(jsonFormat, filePath);
        return setResultSuccess();
    }

    @Override
    @Transactional
    public ResponseBase deleteMainContract(Long id) {
        Contract contract = new Contract();
        contract.setId(id);
        contract.setMainContract(0);
        //更新合约类型为普通合约
        contractMapper.updateByPrimaryKeySelective(contract);
        //删除配置文件
        String json = FileUtil.readJson(filePath);
        List<Contract> contracts = JSON.parseArray(json,Contract.class);
        contracts = contracts.stream().filter(w->w.getId()!= id).collect(Collectors.toList());
        String jsonStr = JSON.toJSONString(contracts);
        String jsonFormat = JsonFormatTool.formatJson(jsonStr);
        FileUtil.writeJson(jsonFormat, filePath);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateQueryContract(Long id) {
        ContractCustom contractCustom = contractCustomMapper.queryById(id);
        return setResultSuccess(contractCustom);
    }
}
