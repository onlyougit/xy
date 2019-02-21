package com.sptwin.xy.mapper;

import com.sptwin.xy.entity.SysUser;
import com.sptwin.xy.pojo.SysUserCustom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SysUserCustomMapper {
    SysUserCustom queryByUserName(String userName);

    @Update("update t_sys_user set last_login_time=login_time, login_time=now(), login_count=login_count+1, gmt_modify=now() where user_name=#{userName}")
    void updateByUserName(String userName);

    List<SysUserCustom> queryUserPage();

    @Select("select count(1) from t_sys_user where user_name=#{userName}")
    int queryByUserNameCount(String userName);

    void batchInsert(@Param("id")Integer id, @Param("list")List idList);

    @Delete("delete from t_sys_user_role where user_id = #{id}")
    void deleteByUserId(Integer id);

    void insertSelective(SysUser sysUser);

    SysUserCustom queryById(Integer id);
}