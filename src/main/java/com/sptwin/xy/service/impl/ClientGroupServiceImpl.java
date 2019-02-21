package com.sptwin.xy.service.impl;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.entity.ClientGroup;
import com.sptwin.xy.mapper.ClientAgentMapper;
import com.sptwin.xy.mapper.ClientCustomMapper;
import com.sptwin.xy.mapper.ClientGroupCustomMapper;
import com.sptwin.xy.mapper.ClientGroupMapper;
import com.sptwin.xy.service.ClientGroupService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("clientGroupService")
public class ClientGroupServiceImpl extends BaseApiService implements ClientGroupService {
    @Autowired
    private ClientGroupMapper clientGroupMapper;
    @Autowired
    private ClientGroupCustomMapper clientGroupCustomMapper;
    @Autowired
    private ClientCustomMapper clientCustomMapper;
    @Autowired
    private ClientAgentMapper clientAgentMapper;

    @Override
    public ResponseBase queryClientGroupByClientAgentId(Long clientAgentId) {
        List<ClientGroup> clientGroups = clientGroupCustomMapper.queryClientGroupByClientAgentId(clientAgentId);
        return setResultSuccess(clientGroups);
    }

    @Override
    public ResponseBase addClientGroup(ClientGroup clientGroup) {
        //判断编号唯一
        int result = clientGroupCustomMapper.queryCountByNo(clientGroup.getClientGroupNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }
        //生成客户组编号
        String maxNo = clientGroupCustomMapper.queryMaxClientGroupNoByClientAgentId(clientGroup.getClientAgentId());
        String groupNo = generateGroupNo(maxNo, clientGroup.getClientAgentId());
        clientGroup.setClientGroupNo(groupNo);
        int count = clientGroupMapper.insertSelective(clientGroup);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateClientGroup(ClientGroup clientGroup) {
        int count = clientGroupMapper.updateByPrimaryKeySelective(clientGroup);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase deleteClientGroup(Long id) {
        //只有在该分组下没有任何客户信息时才可以删除

        int result = clientCustomMapper.queryCountByClientGroupId(id);
        if(result == 1){
            return setResultError(Constants.DELETE_FAILED);
        }
        int count = clientGroupMapper.deleteByPrimaryKey(id);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.DELETE_FAILED);
        }
    }

    @Override
    public ResponseBase updateQueryClientGroup(Long id) {
        ClientGroup clientGroup = clientGroupMapper.selectByPrimaryKey(id);
        return setResultSuccess(clientGroup);
    }

    public String generateGroupNo(String maxNo, Long clientAgentId){

        if(StringUtils.isEmpty(maxNo)){
            ClientAgent clientAgent = clientAgentMapper.selectByPrimaryKey(clientAgentId);
            String agentNo = clientAgent.getClientAgentNo();
            return agentNo+"-"+1001;
        }else{
            String preFix = maxNo.substring(0,maxNo.indexOf("-"));
            String suffix = maxNo.substring(maxNo.indexOf("-")+1);
            return preFix+"-"+(Integer.valueOf(suffix)+1);
        }
    }

}
