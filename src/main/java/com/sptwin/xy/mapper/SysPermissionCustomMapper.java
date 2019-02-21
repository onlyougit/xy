package com.sptwin.xy.mapper;

import com.sptwin.xy.dto.LeftMenuResponseDTO;
import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.pojo.SysPermissionCustom;

import java.util.List;

public interface SysPermissionCustomMapper {
    SysPermission queryByRoleId(Integer roleId);

    List<SysPermissionCustom> queryPermissionPage();

    List<Integer> queryPermissionByRoleIds(List<Integer> list);

    List<LeftMenuResponseDTO> queryPermissionByIds(List<Integer> permissionIds);
}