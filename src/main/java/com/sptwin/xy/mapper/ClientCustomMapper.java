package com.sptwin.xy.mapper;

import com.sptwin.xy.pojo.ClientCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClientCustomMapper {
    @Select("select count(1) from t_client where client_agent_id = #{id}")
    int queryCountByClientAgentId(Long id);

    @Select("select count(1) from t_client where client_group_id = #{id}")
    int queryCountByClientGroupId(Long id);

    List<ClientCustom> queryClientPage(@Param("clientAgentId") Long clientAgentId,
                                       @Param("clientGroupId") Long clientGroupId,
                                       @Param("list") List<String> list);

    @Select("select count(1) from t_client where client_no = #{clientNo}")
    int queryCountByNo(String clientNo);

    ClientCustom queryByClientNo(String clientNo);

    List<ClientCustom> queryClientByAgentIds(List<Long> list);

    List<ClientCustom> queryClientByGroupIds(List<Long> list);
}