package com.sptwin.xy.service.impl;

import com.github.pagehelper.PageHelper;
import com.sptwin.xy.config.MyException;
import com.sptwin.xy.dto.LeftMenuResponseDTO;
import com.sptwin.xy.entity.ClientGroup;
import com.sptwin.xy.entity.SysUser;
import com.sptwin.xy.entity.SysUserClient;
import com.sptwin.xy.enums.UserStatus;
import com.sptwin.xy.mapper.*;
import com.sptwin.xy.pojo.ClientAgentCustom;
import com.sptwin.xy.pojo.ClientCustom;
import com.sptwin.xy.pojo.SysRoleCustom;
import com.sptwin.xy.pojo.SysUserCustom;
import com.sptwin.xy.service.SysUserService;
import com.sptwin.xy.utils.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wangweibin on 2017/2/22.
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseApiService implements SysUserService {
    @Value("${user.default.pwd}")
    private String defaultPw;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysUserCustomMapper sysUserCustomMapper;
    @Autowired
    private SysRoleCustomMapper sysRoleCustomMapper;
    @Autowired
    private SysPermissionCustomMapper sysPermissionCustomMapper;
    @Autowired
    private SysUserClientMapper sysUserClientMapper;
    @Autowired
    private ClientGroupCustomMapper clientGroupCustomMapper;
    @Autowired
    private ClientAgentCustomMapper clientAgentCustomMapper;
    @Autowired
    private ClientCustomMapper clientCustomMapper;

    public ResponseBase loginCheck(String userName, String password, HttpServletRequest request) {
        Map map = new HashMap();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            //登录后，更新用户信息
            sysUserCustomMapper.updateByUserName(userName);
            SysUser sysUser = sysUserCustomMapper.queryByUserName(userName);
            map.put("userId", sysUser.getId());
            map.put("userName", sysUser.getUserName());
            return setResultSuccess(map);
        }catch (AuthenticationException exception){
            throw new MyException(401,"用户名或密码错误！");
        }
    }

    @Override
    public ResponseBase queryUserPage(Integer pageIndex, Integer pageSize) {
        Map map = new HashMap();
        PageHelper.startPage(pageIndex+1, pageSize);
        List<SysUserCustom> userCustomList = sysUserCustomMapper.queryUserPage();
        PageBean<SysUserCustom> pb = new PageBean(userCustomList);
        map.put("data", pb.getList());
        map.put("total", pb.getTotal());
        return setResultSuccess(map);
    }

    @Override
    public ResponseBase queryUserClient(Integer userId) {
        Map map = new HashMap();
        SysUserClient sysUserClient = sysUserClientMapper.queryByUserId(userId);
        List<ClientAgentCustom> allocated = new ArrayList<>();
        List<ClientAgentCustom> unallocated = new ArrayList<>();
        List<Long> agentIdList1 = new ArrayList<>();
        //查询已分配
        if(!StringUtils.isEmpty(sysUserClient)){
            String agentIds = sysUserClient.getAgentIds();
            List<Long> agentIdList = Arrays.asList(agentIds.split(",")).stream().map(w->Long.parseLong(w)).collect(Collectors.toList());
            if(agentIdList.size() > 0){
                agentIdList1 = agentIdList;
                allocated = clientAgentCustomMapper.queryAgentAndGroupByAgentIds(agentIdList);
            }
        }
        //查询未分配
        unallocated = clientAgentCustomMapper.queryAgentAndGroupByNotInAgentIds(agentIdList1);
        map.put("allocated", allocated);
        map.put("unallocated", unallocated);
        return setResultSuccess(map);
    }


    @Override
    public ResponseBase addUserClient(SysUserClient sysUserClient) {
        sysUserClientMapper.insertSelective(sysUserClient);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateUserClient(SysUserClient sysUserClient) {
        int count = sysUserClientMapper.updateByUserId(sysUserClient);
        return setResultSuccess();
    }

    @Override
    public ResponseBase queryLeftMenu() {
        SysUserCustom sysUserCustom = (SysUserCustom) SecurityUtils.getSubject().getPrincipal();
        Integer userId = sysUserCustom.getId();
        //查询角色
        List<SysRoleCustom> sysRoleCustoms = sysRoleCustomMapper.queryByUserId(userId);
        List<Integer> roleIds = sysRoleCustoms.stream().map(w->w.getId()).collect(Collectors.toList());
        //查询菜单ID
        List<Integer> permissionIds = sysPermissionCustomMapper.queryPermissionByRoleIds(roleIds);
        //查询菜单
        List<LeftMenuResponseDTO> list = sysPermissionCustomMapper.queryPermissionByIds(permissionIds);
        List<LeftMenuResponseDTO> parentList = list.stream().filter(w->w.getParentId()==0).collect(Collectors.toList());
        parentList.forEach(w->{
            Integer id = w.getId();
            if(id == 1){//客户管理
                SysUserClient sysUserClient = sysUserClientMapper.queryByUserId(userId);
                if(!StringUtils.isEmpty(sysUserClient)){
                    String agentIds = sysUserClient.getAgentIds();
                    if(!StringUtils.isEmpty(agentIds)){
                        List<LeftMenuResponseDTO> agentList = new ArrayList<>();
                        List<Long> agentIdList = Arrays.asList(agentIds.split(",")).stream().map(m->Long.parseLong(m)).collect(Collectors.toList());
                        List<ClientAgentCustom> clientAgentCustoms = clientAgentCustomMapper.queryAgentAndGroupByAgentIds(agentIdList);
                        clientAgentCustoms.forEach(h->{
                            LeftMenuResponseDTO agent = new LeftMenuResponseDTO();
                            agent.setId(10000+h.getId().intValue());
                            agent.setParentId(1);
                            agent.setPermissionName(h.getClientAgentName());
                            agent.setType("menu");
                            agent.setPermission("agent:*");
                            agent.setUrl("/client/query/agent");
                            List<ClientGroup> clientGroups = h.getClientGroupList();
                            if(!CollectionUtils.isEmpty(clientGroups)){
                                List<LeftMenuResponseDTO> groupList = new ArrayList<>();
                                clientGroups.forEach(p->{
                                    LeftMenuResponseDTO group = new LeftMenuResponseDTO();
                                    group.setId(100000+p.getId().intValue());
                                    group.setParentId(agent.getId());
                                    group.setPermissionName(p.getClientGroupName());
                                    group.setType("menu");
                                    group.setPermission("group:*");
                                    group.setUrl("/client/query/group");
                                    groupList.add(group);
                                });
                                agent.setList(groupList);
                            }
                            agentList.add(agent);
                        });
                        w.setList(agentList);
                    }
                }
            }else{
                List<LeftMenuResponseDTO> tmpList = list.stream().filter(y->y.getParentId().equals(id)).collect(Collectors.toList());
                w.setList(tmpList);
            }
        });
        return setResultSuccess(parentList);
    }
    @Override
    public List<String> queryClientByUserId(Integer userId) {
        SysUserClient sysUserClient = sysUserClientMapper.queryByUserId(userId);
        if(!StringUtils.isEmpty(sysUserClient)){
            String agentIds = sysUserClient.getAgentIds();
            if(!StringUtils.isEmpty(agentIds)){
                List<Long> agentIdList = Arrays.asList(agentIds.split(",")).stream().map(w->Long.parseLong(w)).collect(Collectors.toList());
                List<ClientCustom> clientCustoms = clientCustomMapper.queryClientByAgentIds(agentIdList);
                List<String> agentClientIds = clientCustoms.stream().map(w->w.getClientNo()).collect(Collectors.toList());
                return agentClientIds;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public ResponseBase addUser(SysUserCustom sysUserCustom) {
        //判断用户名是否存在
        int result = sysUserCustomMapper.queryByUserNameCount(sysUserCustom.getUserName());
        if(result > 0){
            return setResultError(Constants.USER_EXIST);
        }
        sysUserCustom.setGmtCreate(new Date());
        sysUserCustom.setStatus(UserStatus.Y.ordinal());
        String salt = sysUserCustom.getUserName()+new SecureRandomNumberGenerator().nextBytes().toHex();
        sysUserCustom.setPassword(EncryptUtil.entryptPassword( defaultPw,salt));
        sysUserCustom.setSalt(salt);

        sysUserCustomMapper.insertSelective(sysUserCustom);
        //再添加用户角色表
        List<SysRoleCustom> sysRoleCustomList = sysUserCustom.getSysRoleCustomList();
        if(null != sysRoleCustomList && sysRoleCustomList.size()>0){
            List idList = sysRoleCustomList.stream().map(w->w.getId()).collect(Collectors.toList());
            sysUserCustomMapper.batchInsert(sysUserCustom.getId(),idList);
        }
        return setResultSuccess();
    }

    @Override
    @Transactional
    public ResponseBase updateUser(SysUserCustom sysUserCustom) {
        //判断用户名是否存在
        int result = sysUserCustomMapper.queryByUserNameCount(sysUserCustom.getUserName());
        if(result > 0){
            return setResultError(Constants.USER_EXIST);
        }
        sysUserCustom.setGmtModify(new Date());
        sysUserMapper.updateByPrimaryKeySelective(sysUserCustom);
        //再添加用户角色表(先删除该用户所有角色)
        sysUserCustomMapper.deleteByUserId(sysUserCustom.getId());
        List<SysRoleCustom> sysRoleCustomList = sysUserCustom.getSysRoleCustomList();
        if(null != sysRoleCustomList && sysRoleCustomList.size()>0){
            List idList = sysRoleCustomList.stream().map(w->w.getId()).collect(Collectors.toList());
            sysUserCustomMapper.batchInsert(sysUserCustom.getId(),idList);
        }
        return setResultSuccess();
    }
    @Override
    public ResponseBase deleteUser(Integer id) {
        SysUser user = new SysUser();
        user.setGmtModify(new Date());
        user.setId(id);
        user.setStatus(UserStatus.N.ordinal());
        sysUserMapper.updateByPrimaryKeySelective(user);
        return setResultSuccess();
    }

    @Override
    public ResponseBase updateQueryUser(Integer id) {
        SysUserCustom sysUserCustom = sysUserCustomMapper.queryById(id);
        return setResultSuccess(sysUserCustom);
    }
}