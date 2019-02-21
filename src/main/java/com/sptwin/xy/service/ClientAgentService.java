package com.sptwin.xy.service;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.utils.ResponseBase;

public interface ClientAgentService {
    ResponseBase addClientAgent(ClientAgent clientAgent);

    ResponseBase updateClientAgent(ClientAgent clientAgent);

    ResponseBase queryClientAgent();

    ResponseBase deleteClientAgent(Long id);

    ResponseBase updateQueryClientAgent(Long id);
}
