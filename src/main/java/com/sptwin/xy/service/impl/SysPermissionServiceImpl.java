package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.SysPermission;
import com.sptwin.xy.enums.UserStatus;
import com.sptwin.xy.mapper.SysPermissionCustomMapper;
import com.sptwin.xy.mapper.SysPermissionMapper;
import com.sptwin.xy.pojo.SysPermissionCustom;
import com.sptwin.xy.service.SysPermissionService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.PageBean;
import com.sptwin.xy.utils.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangweibin on 2017/2/22.
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends BaseApiService implements SysPermissionService {
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Autowired
    private SysPermissionCustomMapper sysPermissionCustomMapper;


    @Override
    public ResponseBase queryPermissionPage(Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<SysPermissionCustom> permissionCustomList = sysPermissionCustomMapper.queryPermissionPage();
        PageBean<SysPermissionCustom> pb = new PageBean(permissionCustomList);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    @Transactional
    public ResponseBase addPermission(SysPermission sysPermission) {
        //判断角色名称是否存在
        sysPermission.setGmtCreate(new Date());
        sysPermission.setStatus(UserStatus.Y.ordinal());
        sysPermissionMapper.insertSelective(sysPermission);
        return setResultSuccess();
    }

    @Override
    @Transactional
    public ResponseBase updatePermission(SysPermission sysPermission) {
        sysPermission.setGmtModify(new Date());
        sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updatePermissionQuery(Integer id) {
        SysPermission sysPermission = sysPermissionMapper.selectByPrimaryKey(id);
        return setResultSuccess(sysPermission);
    }

    @Override
    public ResponseBase deletePermission(Integer id) {
        SysPermission permission = new SysPermission();
        permission.setGmtModify(new Date());
        permission.setId(id);
        permission.setStatus(UserStatus.N.ordinal());
        sysPermissionMapper.updateByPrimaryKeySelective(permission);
        return setResultSuccess();
    }
}