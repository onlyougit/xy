package com.sptwin.xy.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
    //加密次数
    public static final Integer hashIterations = 3;

    /**
     * 密码MD5+salt加密
     * @param password
     * @return
     */
    public static String encrypt(String password, String salt){
        return new Md5Hash(password,salt,hashIterations).toString();
    }

    /**
     * 后台密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String entryptPassword(String password, String salt){
        SimpleHash hash = new SimpleHash(Constants.ALGORITHMNAME, password, ByteSource.Util.bytes(salt), Constants.HASHITERATIONS);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
}
