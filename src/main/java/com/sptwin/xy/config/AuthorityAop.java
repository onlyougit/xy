package com.sptwin.xy.config;

import com.sptwin.xy.pojo.SysUserCustom;
import com.sptwin.xy.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class AuthorityAop {

    @Autowired
    private SysUserService sysUserService;

    @Pointcut("@annotation(com.sptwin.xy.config.Authority)")
    public void adminOnly(){}

    @Around("adminOnly()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable{
        List<String> initList  = new ArrayList<>();
        SysUserCustom sysUserCustom = (SysUserCustom) SecurityUtils.getSubject().getPrincipal();
        Field field = joinPoint.getTarget().getClass().getDeclaredField("list");
        field.setAccessible(true);
        field.set(joinPoint.getTarget(),initList);
        //判断一下是不是admin
        if(!"admin".equalsIgnoreCase(sysUserCustom.getUserName())){
            List<String> list = sysUserService.queryClientByUserId(sysUserCustom.getId());
            if(null != list && list.size() > 0){
                field.set(joinPoint.getTarget(),list);
            }else{
                list.add("-1");
                field.set(joinPoint.getTarget(),list);
            }
        }
        Object obj= joinPoint.proceed();
        return obj;
    }
}
