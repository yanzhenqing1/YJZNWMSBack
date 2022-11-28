package com.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Component;

/**
 * shiro md5工具类
 * 
 * @author 谭永波
 */
@Component
public class ShiroUtils
{

    /**
     * 生成随机盐
     *
     * @author 谭永波
     */
    public String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }

    /**
     * md5加密(账号+密码+盐)
     *
     * @author 谭永波
     */
    public String encryptPassword(String loginName, String password, String salt)
    {
        return new Md5Hash(loginName + password + salt).toHex();
    }




}
