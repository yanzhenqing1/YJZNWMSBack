package com.service;

import com.bean.TblAppUser;
import com.bean.TblWarehouse;
import com.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TblUserService {

    //用户登录(返回一个token、用户真实姓名、手机的集合)手机验证码登录sms
    public String smslogin(String phone, HttpServletRequest request);

    //用户账号（手机号，邮箱，用户名）密码登录(返回一个token、用户真实姓名、手机的集合)
    public String pwdlogin(String ppe,String pwd,HttpServletRequest request);

    //查询用户信息
    public TblAppUser userInfo(String ppe);

    //用户注册
    int userRegister(String TRUEName,String loginName,String phone,String password);

    //用户注册
    Result upUserPassword(String password, String phone);



}
