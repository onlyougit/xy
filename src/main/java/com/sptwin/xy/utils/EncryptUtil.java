package com.sptwin.xy.utils;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptUtil {


    public static String entryptPassword(String password, String salt){
        SimpleHash hash = new SimpleHash(Constants.ALGORITHMNAME, password, ByteSource.Util.bytes(salt), Constants.HASHITERATIONS);
        String encodedPassword = hash.toHex();
        return encodedPassword;
    }
}
