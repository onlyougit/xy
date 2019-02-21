package com.sptwin.xy.pojo;

import com.sptwin.xy.entity.SysUser;
import com.sptwin.xy.enums.UserStatus;
import lombok.Data;

import java.util.List;

@Data
public class SysUserCustom extends SysUser {

    private List<SysRoleCustom> sysRoleCustomList;

    private UserStatus userStatusEnum;
}
