package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.SysRole;
import com.sptwin.xy.pojo.SysRoleCustom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleCustomMapper {
    List<SysRoleCustom> queryByUserId(Integer userId);

    List<SysRoleCustom> queryRolePage();

    @Select("select count(1) from t_sys_role where role_name=#{roleName}")
    int queryByRoleNameCount(String roleName);

    @Select("select id,role_name roleName from t_sys_role")
    List<SysRole> queryRole();
}