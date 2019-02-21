package com.sptwin.xy.service;


import com.sptwin.xy.entity.SysUserClient;
import com.sptwin.xy.pojo.SysUserCustom;
import com.sptwin.xy.utils.ResponseBase;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wangweibin on 2017/2/22.
 */
public interface SysUserService {

    //登录校验【根据用户和密码】
    public ResponseBase loginCheck(String userName, String password, HttpServletRequest request);

    ResponseBase queryUserPage(Integer pageIndex, Integer pageSize);

    List<String> queryClientByUserId(Integer userId);

    ResponseBase addUser(SysUserCustom sysUserCustom);

    ResponseBase updateUser(SysUserCustom sysUserCustom);

    ResponseBase deleteUser(Integer id);

    ResponseBase updateQueryUser(Integer id);

    ResponseBase addUserClient(SysUserClient sysUserClient);

    ResponseBase queryUserClient(Integer userId);

    ResponseBase updateUserClient(SysUserClient sysUserClient);

    ResponseBase queryLeftMenu();
}
