package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.entity.SysRole;
import com.sptwin.xy.enums.UserStatus;
import com.sptwin.xy.mapper.SysRoleCustomMapper;
import com.sptwin.xy.mapper.SysRoleMapper;
import com.sptwin.xy.pojo.SysRoleCustom;
import com.sptwin.xy.service.SysRoleService;
import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.Constants;
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
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseApiService implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleCustomMapper sysRoleCustomMapper;


    @Override
    public ResponseBase queryRolePage(Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<SysRoleCustom> roleCustomList = sysRoleCustomMapper.queryRolePage();
        PageBean<SysRoleCustom> pb = new PageBean(roleCustomList);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    @Transactional
    public ResponseBase addRole(SysRole sysRole) {
        //判断角色名称是否存在
        int result = sysRoleCustomMapper.queryByRoleNameCount(sysRole.getRoleName());
        if(result > 0){
            return setResultError(Constants.ROLE_EXIST);
        }
        sysRole.setGmtCreate(new Date());
        sysRole.setStatus(UserStatus.Y.ordinal());
        sysRoleMapper.insertSelective(sysRole);
        return setResultSuccess();
    }

    @Override
    @Transactional
    public ResponseBase updateRole(SysRole sysRole) {
        int result = sysRoleCustomMapper.queryByRoleNameCount(sysRole.getRoleName());
        if(result > 0){
            return setResultError(Constants.ROLE_EXIST);
        }
        sysRole.setGmtModify(new Date());
        sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateRoleQuery(Integer id) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(id);
        return setResultSuccess(sysRole);
    }

    @Override
    public ResponseBase queryRole() {
        List<SysRole> sysRoles = sysRoleCustomMapper.queryRole();
        return setResultSuccess(sysRoles);
    }

    @Override
    public ResponseBase deleteRole(Integer id) {
        SysRole role = new SysRole();
        role.setGmtModify(new Date());
        role.setId(id);
        role.setStatus(UserStatus.N.ordinal());
        sysRoleMapper.updateByPrimaryKeySelective(role);
        return setResultSuccess();
    }
}