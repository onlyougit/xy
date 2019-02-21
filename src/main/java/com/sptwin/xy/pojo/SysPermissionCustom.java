package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.enums.UserStatus;
import lombok.Data;

@Data
public class SysPermissionCustom extends SysPermission {

    private UserStatus userStatusEnum;

}
