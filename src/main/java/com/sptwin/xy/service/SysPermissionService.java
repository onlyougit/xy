package com.sptwin.xy.service;


import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.utils.ResponseBase;

/**
 * Created by wangweibin on 2017/2/22.
 */
public interface SysPermissionService {

    ResponseBase queryPermissionPage(Integer pageIndex, Integer pageSize);

    ResponseBase addPermission(SysPermission sysPermission);

    ResponseBase updatePermissionQuery(Integer id);

    ResponseBase updatePermission(SysPermission sysPermission);

    ResponseBase deletePermission(Integer id);
}
