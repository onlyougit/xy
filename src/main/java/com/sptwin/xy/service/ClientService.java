package com.sptwin.xy.service;

import com.sptwin.xy.entity.Client;
import com.sptwin.xy.entity.ClientRateRelation;
import com.sptwin.xy.pojo.ClientCustom;
import com.sptwin.xy.utils.ResponseBase;

public interface ClientService {

    ResponseBase queryClientPage(ClientCustom clientCustom, Integer pageIndex, Integer pageSize);

    ResponseBase addClient(Client client);

    ResponseBase updateClient(Client client);

    ResponseBase login(String clientNo, String password);

    ResponseBase addClientRateRelation(ClientRateRelation clientRateRelation);

    ResponseBase updateQueryClient(Long id);

    ResponseBase queryClientByAgentId(Long agentId);

    ResponseBase queryClientByGroupId(Long groupId);
}
