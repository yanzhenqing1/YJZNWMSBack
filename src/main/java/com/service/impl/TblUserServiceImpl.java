package com.service.impl;

import com.bean.TblAppUser;
import com.mapper.TblUserMapper;
import com.service.TblUserService;
import com.utils.IpUtils;
import com.utils.JwtUtil;
import com.utils.Result;
import com.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class TblUserServiceImpl implements TblUserService {

    //
    @Autowired
    TblUserMapper tblUserMapper;

    @Autowired
    ShiroUtils shiroUtils;

    //返回一个token
    @Override
    public String smslogin(String phone,HttpServletRequest request) {
        //查询数据库是否已有号码
        TblAppUser user = tblUserMapper.findAppUser(phone);
        HashMap<String, String> plMap = new HashMap<>();
        if(user!=null){
            //存储载荷声明参数map
            plMap.put("ppe",phone);
            plMap.put("username",user.getUser_name());
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println("登录时间："+dateFormat.format(date));
            //判断是否服务器内网登录
            System.out.println("用户请求地址:"+IpUtils.getIpAddr(request));
            System.out.println("是否本地IP:"+IpUtils.internalIp(IpUtils.getIpAddr(request)));
            String loginIp=null;
            if(IpUtils.internalIp(IpUtils.getIpAddr(request))){
                loginIp="127.0.0.1";
            }else {
                loginIp=IpUtils.getIpAddr(request);
            }
            //添加登录信息
            int re=tblUserMapper.upUserLoginInfo(
                    user.getSex(),
                    user.getAvatar(),
                    loginIp,
                    dateFormat.format(date),
                    user.getPassword(),
                    user.getSalt(),
                    phone,
                    user.getUpdate_time()
            );
        }
        else {
            return null;
        }
        return JwtUtil.getToken(plMap);
    }
    //账号密码登录
    @Override
    public String pwdlogin(String ppe,String pwd,HttpServletRequest request) {
        //查询数据库是否有对应账号
        TblAppUser user = tblUserMapper.findAppUser(ppe);
        HashMap<String, String> plMap = new HashMap<>();
        if(user!=null){
            String loginPwd= shiroUtils.encryptPassword(user.getLogin_name(),pwd,user.getSalt());
            System.out.println("登录密码md5加密结果："+loginPwd+"|| 数据库内密码："+user.getPassword());
            System.out.println("登录ip："+IpUtils.getHostIp()+"|| 登录名："+IpUtils.getHostName());

            if (user.getPassword().equals(loginPwd)){
                //存储载荷声明参数map
                plMap.put("ppe",user.getPhonenumber());
                plMap.put("username",user.getUser_name());
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                System.out.println("登录时间："+dateFormat.format(date));
                //判断是否服务器内网登录
                System.out.println("用户请求地址:"+IpUtils.getIpAddr(request));
                System.out.println("是否本地IP:"+IpUtils.internalIp(IpUtils.getIpAddr(request)));
                String loginIp=null;
                if(IpUtils.internalIp(IpUtils.getIpAddr(request))){
                    loginIp="127.0.0.1";
                }else {
                    loginIp=IpUtils.getIpAddr(request);
                }
                //添加登录信息
                int re=tblUserMapper.upUserLoginInfo(
                        user.getSex(),
                        user.getAvatar(),
                        loginIp,
                        dateFormat.format(date),
                        user.getPassword(),
                        user.getSalt(),
                        user.getPhonenumber(),
                        user.getUpdate_time()
                );
            }else {
                return null;
            }
        }
        else {
            return null;
        }
        return JwtUtil.getToken(plMap);
    }
    //获取用户信息
    @Override
    public TblAppUser userInfo(String ppe) {
        return tblUserMapper.findAppUser(ppe);
    }
    //用户注册
    @Override
    public int userRegister(String TRUEName, String loginName, String phone, String password) {
        TblAppUser phoneUser = tblUserMapper.findAppUser(phone);
        TblAppUser loginNameUser = tblUserMapper.findAppUser(loginName);
        if(loginNameUser!=null){
            return -1;
        }
        if(phoneUser!=null){
            return -2;
        }
        //生成盐
        String loginSalt= shiroUtils.randomSalt();
        //md5加密
        String loginPwd= shiroUtils.encryptPassword(loginName,password,loginSalt);
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("当前时间："+dateFormat.format(date));
        boolean re= tblUserMapper.userRegister(loginName,TRUEName,phone,loginPwd,loginSalt,dateFormat.format(date));
        if(re){
            return 1;
        }
        return 0;
    }
    //用户密码修改
    @Override
    public Result upUserPassword(String password, String phone) {
        //查询手机号是否存在对应用户
        TblAppUser phoneUser = tblUserMapper.findAppUser(phone);
        if(phoneUser!=null){
            //生成盐
            String salt= shiroUtils.randomSalt();
            //md5加密
            String newPwd= shiroUtils.encryptPassword(phoneUser.getLogin_name(),password,salt);
            //获取当前时间
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println("修改密码时间："+dateFormat.format(date));
            //修改密码
            int re=tblUserMapper.upUserLoginInfo(phoneUser.getSex(),
                                                    phoneUser.getAvatar(),
                                                    phoneUser.getLogin_ip(),
                                                    phoneUser.getLogin_date(),
                                                    newPwd,
                                                    salt,
                                                    phone,
                                                    dateFormat.format(date));
            if (re==1){
                return Result.ok(phone);
            }
            return Result.error();
        }
        return Result.error();
    }




}
