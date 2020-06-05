package com.demo.common.utils;

import com.demo.common.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * @author lkz
 * @date 2020-06-04 10:42
 * @describe
 */
public class Md5Utils {

    private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5s(String s)
    {
        MessageDigest algorithm;
        try
        {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        }
        catch (Exception e)
        {
            log.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte[] hash)
    {
        if (hash == null)
        {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++)
        {
            if ((hash[i] & 0xff) < 0x10)
            {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String md5(String s)
    {
        try
        {
            return new String(toHex(md5s(s)).getBytes("UTF-8"), "UTF-8");
        }
        catch (Exception e)
        {
            log.error("not supported charset...{}", e);
            return s;
        }
    }

    /**
     * 获取用户加密密码(MD5 大写)
     * @param pwd
     * @return
     */
    public static String getPwdUpperCase(String pwd){
        String password = "";
        //用户默认密码
        if(null==pwd || "".equals(pwd)){
            pwd= Constants.PASSWORD;
        }
        password= md5(pwd).toUpperCase();
        return password;
    }
    /**
     * 获取用户加密密码(MD5 小写)
     * @param pwd
     * @return
     */
    public static String getPwdLowerCase(String pwd){
        String password = "";
        //用户默认密码
        if(null==pwd || "".equals(pwd)){
            pwd= Constants.PASSWORD;
        }
        password= md5(pwd);
        return password;
    }

    /**
     * 判断密码是否相等 （大写）
     * @param pwd1 加密前密码
     * @param pwd2 加密后密码
     * @return
     */
    public static Boolean isEqualPwdUpper(String pwd1,String pwd2){
        boolean falg = false;
        if(pwd2.equals(getPwdUpperCase(pwd1))){
            falg =true;
        }
        return falg;
    }
    /**
     * 判断密码是否相等 (小写）
     * @param pwd1 加密前密码
     * @param pwd2 加密后密码
     * @return
     */
    public static Boolean isEqualPwdLower(String pwd1,String pwd2){
        boolean falg = false;
        if(pwd2.equals(getPwdLowerCase(pwd1))){
            falg =true;
        }
        return falg;
    }

    public static void main(String[] args) {
        System.out.println(getPwdUpperCase(""));
        System.out.println(getPwdLowerCase(""));
        System.out.println(System.getProperty("user.dir"));
    }


}
