package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.SysRole;
import com.sptwin.xy.enums.UserStatus;
import lombok.Data;

import java.util.List;

@Data
public class SysRoleCustom extends SysRole {
    private List<SysPermissionCustom> sysPermissionCustomList;

    private UserStatus userStatusEnum;

}
