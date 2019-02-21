package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.config.Authority;
import com.sptwin.xy.entity.Client;
import com.sptwin.xy.entity.ClientRateRelation;
import com.sptwin.xy.mapper.ClientCustomMapper;
import com.sptwin.xy.mapper.ClientGroupCustomMapper;
import com.sptwin.xy.mapper.ClientMapper;
import com.sptwin.xy.mapper.ClientRateRelationMapper;
import com.sptwin.xy.pojo.ClientCustom;
import com.sptwin.xy.service.ClientService;
import com.sptwin.xy.utils.*;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("clientService")
public class ClientServiceImpl extends BaseApiService implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private ClientCustomMapper clientCustomMapper;
    @Autowired
    private ClientRateRelationMapper clientRateRelationMapper;
    @Autowired
    private ClientGroupCustomMapper clientGroupCustomMapper;
    public List<String> list  = new ArrayList<>();

    @Override
    @Authority
    public ResponseBase queryClientPage(ClientCustom clientCustom, Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<ClientCustom> clientCustoms = clientCustomMapper.queryClientPage(clientCustom.getClientAgentId(),clientCustom.getClientGroupId(),list);
        PageBean<ClientCustom> pb = new PageBean(clientCustoms);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase addClient(Client client) {
        //判断编号唯一
        int result = clientCustomMapper.queryCountByNo(client.getClientNo());
        if(result > 0){
            return setResultError(Constants.NO_EXIST);
        }

        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        client.setSalt(salt);
        client.setClientPassword(PasswordUtil.encrypt(client.getClientPassword(), salt));
        client.setClientRegistDate(new Date());
        int count = clientMapper.insertSelective(client);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateClient(Client client) {
        int count = clientMapper.updateByPrimaryKeySelective(client);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.UPDATE_FAILED);
        }
    }

    @Override
    public ResponseBase login(String clientNo, String password) {
        ClientCustom clientCustom = clientCustomMapper.queryByClientNo(clientNo);
        String pw = PasswordUtil.encrypt(password, clientCustom.getSalt());
        if(pw.equalsIgnoreCase(clientCustom.getClientPassword())){
            return setResultSuccess("登录成功");
        }
        return setResultError("登录失败");
    }

    @Override
    public ResponseBase addClientRateRelation(ClientRateRelation clientRateRelation) {
        int count = clientRateRelationMapper.insertSelective(clientRateRelation);
        if(count == 1){
            return setResultSuccess();
        }else{
            return setResultError(Constants.ADD_FAILED);
        }
    }

    @Override
    public ResponseBase updateQueryClient(Long id) {
        Client client = clientMapper.selectByPrimaryKey(id);
        return setResultSuccess(client);
    }

    @Override
    public ResponseBase queryClientByAgentId(Long agentId) {
        List<Long> list = new ArrayList<>();
        list.add(agentId);
        List<ClientCustom> clientCustoms = clientCustomMapper.queryClientByAgentIds(list);
        return setResultSuccess(clientCustoms);
    }

    @Override
    public ResponseBase queryClientByGroupId(Long groupId) {
        List<Long> list = new ArrayList<>();
        list.add(groupId);
        List<ClientCustom> clientCustoms = clientCustomMapper.queryClientByGroupIds(list);
        return setResultSuccess(clientCustoms);
    }
}
