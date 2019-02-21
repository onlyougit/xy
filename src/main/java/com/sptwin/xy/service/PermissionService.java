package com.sptwin.xy.service;

import com.sptwin.xy.entity.SysUser;

import java.util.List;

public interface PermissionService {

    //批量删除权限
    public void batchDeletePermission(List permissionIdList)throws Exception;
    //判断此URL是否需要权限验证
    public boolean isExistPermission(String requestPath);
    //判断是否有权限
    public boolean isHavingPermission(SysUser sysUser, String requestPath);
    //查询出权限名称
    public String selectPermissionByUrl(String requestPath);
}
