package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.ClientGroup;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientGroupCustomMapper {
    @Select("select id, client_group_no clientGroupNo, client_group_name clientGroupName from t_client_group where client_agent_id = #{clientAgentId}")
    List<ClientGroup> queryClientGroupByClientAgentId(Long clientAgentId);

    @Select("select count(1) from t_client_group where client_group_no = #{clientGroupNo}")
    int queryCountByNo(String clientGroupNo);

    @Select("select max(client_group_no) from t_client_group where client_agent_id = #{clientAgentId}")
    String queryMaxClientGroupNoByClientAgentId(Long clientAgentId);

    List<ClientGroup> queryByAgentId(Long agentId);

    List<ClientGroup> queryGroupIdsByAgentIds(@Param("list") List<Long> agentIdList);
}