package com.sptwin.xy.config;

import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.enums.UserStatus;
import com.sptwin.xy.mapper.SysUserCustomMapper;
import com.sptwin.xy.pojo.SysRoleCustom;
import com.sptwin.xy.pojo.SysUserCustom;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserCustomMapper sysUserCustomMapper;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUserCustom sysUserCustom = (SysUserCustom) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        for(SysRoleCustom role:sysUserCustom.getSysRoleCustomList()){
            authorizationInfo.addRole(role.getRoleName());
            for(SysPermission p:role.getSysPermissionCustomList()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();

        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUserCustom sysUserCustom = sysUserCustomMapper.queryByUserName(userName);

        if (null == sysUserCustom ||
                sysUserCustom.getUserStatusEnum().ordinal() != UserStatus.Y.ordinal()) {
            return null;
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(
                sysUserCustom,
                sysUserCustom.getPassword(),
                ByteSource.Util.bytes(sysUserCustom.getSalt()),//salt=username+salt
                getName());
        return info;
    }
}
