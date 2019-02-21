package com.sptwin.xy.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangweibin on 2017/2/23.
 */
public class LoginInterceptor implements HandlerInterceptor {
    //进入Controller方法之前执行
//    主要用于身份认证、身份授权
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //判断是否是公开地址，一般会在配置文件中配置
        //String url = httpServletRequest.getRequestURI();
       /* StringBuffer url = httpServletRequest.getRequestURL();
        if(url.indexOf("/login/loginCheck.action")>0 || url.indexOf("/Captcah/index.action")>0){
            return true;
        }
        //判断session是否有值
        HttpSession session = httpServletRequest.getSession();
        SessionInfo sessionInfo = (SessionInfo)session.getAttribute(Constants.SESSION_BEAN);
        if(null != sessionInfo){
            SysUser sysUser = sessionInfo.getSysUser();
            if(null != sysUser){
                String userName = sysUser.getUserName();
                if(null != userName){
                    return true;
                }
            }
        }
        httpServletRequest.getRequestDispatcher("/Login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;*/
       return true;
    }
}
