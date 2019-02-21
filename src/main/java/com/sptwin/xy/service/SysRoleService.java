package com.sptwin.xy.service;


import com.sptwin.xy.entity.SysRole;
import com.sptwin.xy.utils.ResponseBase;

/**
 * Created by wangweibin on 2017/2/22.
 */
public interface SysRoleService {

    ResponseBase queryRolePage(Integer pageIndex, Integer pageSize);

    ResponseBase addRole(SysRole sysRole);

    ResponseBase updateRole(SysRole sysRole);

    ResponseBase deleteRole(Integer id);

    ResponseBase updateRoleQuery(Integer id);

    ResponseBase queryRole();
}
