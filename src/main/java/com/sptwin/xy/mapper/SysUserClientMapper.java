package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.SysUserClient;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SysUserClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserClient record);

    int insertSelective(SysUserClient record);

    SysUserClient selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserClient record);

    int updateByPrimaryKey(SysUserClient record);

    @Select("select agent_ids agentIds, group_ids groupIds from t_sys_user_client where user_id=#{userId}")
    SysUserClient queryByUserId(Integer userId);

    @Update("update t_sys_user_client set agent_ids = #{agentIds} where user_id=#{userId}")
    int updateByUserId(SysUserClient sysUserClient);
}