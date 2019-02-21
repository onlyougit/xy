package com.sptwin.xy.service;

import com.sptwin.xy.entity.ClientGroup;
import com.sptwin.xy.utils.ResponseBase;

public interface ClientGroupService {
    ResponseBase queryClientGroupByClientAgentId(Long clientAgentId);

    ResponseBase addClientGroup(ClientGroup clientGroup);

    ResponseBase updateClientGroup(ClientGroup clientGroup);

    ResponseBase deleteClientGroup(Long id);

    ResponseBase updateQueryClientGroup(Long id);
}
