package com.sptwin.xy.config;

import com.sptwin.xy.utils.BaseApiService;
import com.sptwin.xy.utils.ResponseBase;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = {"com.sptwin.xy.controller"})
public class GlobalException extends BaseApiService {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseBase exceptionHandler(Exception e){
        logger.error("global exception .................");
        logger.error(e.getMessage());
        e.printStackTrace();
        if(e instanceof MyException){
            MyException myException = (MyException)e;
            return setResultError(myException.getCode(), myException.getMessage());
        } else if(e instanceof UnauthorizedException){
            return setResultError(403, "该功能需要权限");
        } else{
            return setResultError(500, "系统异常");
        }
    }
}
