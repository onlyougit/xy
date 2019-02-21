package com.sptwin.xy.service.impl;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.mapper.ClientAgentCustomMapper;
import com.sptwin.xy.mapper.ClientAgentMapper;
import com.sptwin.xy.mapper.ClientCustomMapper;
import com.sptwin.xy.service.ClientAgentService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientAgentService")
public class ClientAgentServiceImpl extends BaseApiService implements ClientAgentService {
    @Autowired
    private ClientAgentMapper clientAgentMapper;
    @Autowired
    private ClientAgentCustomMapper clientAgentCustomMapper;
    @Autowired
    private ClientCustomMapper clientCustomMapper;

    @Override
    public ResponseBase addClientAgent(ClientAgent clientAgent) {
        //判断编号唯一
        int result = clientAgentCustomMapper.queryCountByNo(clientAgent.getClientAgentNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        int count = clientAgentMapper.insertSelective(clientAgent);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateClientAgent(ClientAgent clientAgent) {
        int count = clientAgentMapper.updateByPrimaryKeySelective(clientAgent);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase queryClientAgent() {
        List<ClientAgent> clientAgents = clientAgentCustomMapper.queryClientAgent();
        return setResultSuccess(clientAgents);
    }

    @Override
    public ResponseBase deleteClientAgent(Long id) {
        //只有在该代理下没有任何客户分组时才可以删除
        int result = clientCustomMapper.queryCountByClientAgentId(id);
        if(result == 1){
            return setResultError(Constants.DELETE_FAILED);
        }
        int count = clientAgentMapper.deleteByPrimaryKey(id);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.DELETE_FAILED);
        }
    }

    @Override
    public ResponseBase updateQueryClientAgent(Long id) {
        ClientAgent clientAgent = clientAgentMapper.selectByPrimaryKey(id);
        return setResultSuccess(clientAgent);
    }
}
