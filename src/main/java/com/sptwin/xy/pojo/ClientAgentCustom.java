package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.entity.ClientGroup;
import lombok.Data;

import java.util.List;

@Data
public class ClientAgentCustom extends ClientAgent{
    private List<ClientGroup> clientGroupList;

}
