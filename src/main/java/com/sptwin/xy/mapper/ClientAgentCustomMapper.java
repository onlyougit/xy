package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.ClientAgent;
import com.sptwin.xy.pojo.ClientAgentCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientAgentCustomMapper {
    List<ClientAgent> queryClientAgent();

    @Select("select count(1) from t_client_agent where client_agent_no = #{clientAgentNo}")
    int queryCountByNo(String clientAgentNo);

    List<ClientAgentCustom> queryAgentAndGroupByAgentIds(List<Long> agentIdList);

    List<ClientAgentCustom> queryAgentAndGroupByNotInAgentIds(List<Long> agentIdList1);
}