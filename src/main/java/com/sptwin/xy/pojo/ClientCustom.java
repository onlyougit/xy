package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.Client;
import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.entity.ClientGroup;
import com.sptwin.xy.enums.ClientStatus;
import lombok.Data;

@Data
public class ClientCustom extends Client {

    private ClientAgent clientAgent;

    private ClientGroup clientGroup;

    private ClientStatus clientStatusEnum;
}
