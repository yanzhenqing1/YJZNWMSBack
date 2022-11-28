package com.web;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bean.TblAppUser;
import com.service.TblUserService;
import com.utils.JwtUtil;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户模块
 * @author 谭永波
 * @version 1.0.1
 */
@Controller
@RequestMapping("/userApp")
public class UserController {

    //
    @Autowired
    TblUserService tblUserService;

    /**
     * 登录
     *
     * @author 谭永波
     */
    @RequestMapping("/smslogin")
    @ResponseBody
    public Result smslogin(String phone,HttpServletRequest request){
        String login = tblUserService.smslogin(phone,request);
        System.out.println("验证码登陆token："+login);
        if(login!=null){
            return Result.ok(login);
        }else {
            return Result.error();
        }
    }
    /**
     * 密码登录
     *
     * @author 谭永波
     */
    @RequestMapping("/pwdlogin")
    @ResponseBody
    public Result pwdlogin(String ppe, String pwd, HttpServletRequest request){

        String login = tblUserService.pwdlogin(ppe,pwd,request);
        System.out.println("密码登陆："+ppe+" || 密码： "+pwd+"|| Token："+ login);
        if(login!=null){
            return Result.ok(login);
        }else {
            return Result.error();
        }
    }
    /**
     * 通过token获取用户信息
     *
     * @author 谭永波
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public Result getUserInfo( String tok){
        System.out.println("当前的token为："+tok);
        if(tok != null){
            DecodedJWT verify = JwtUtil.getTokenInfo(tok);   //验证令牌
            Claim claim = verify.getClaim("ppe");
            String ppe = claim.asString();
            TblAppUser tblAppUser = tblUserService.userInfo(ppe);
            System.out.println("数据："+Result.ok(tblAppUser));
            return Result.ok(tblAppUser);
        }
        return Result.error();
    }
    /**
     * 注册
     *
     * @author 谭永波
     */
    @RequestMapping("/register")
    @ResponseBody
    public Result register(String TRUEName,String loginName,String phone,String password){
        return Result.ok(tblUserService.userRegister(TRUEName,loginName,phone,password));
    }
    /**
     * 找回/修改密码
     *
     * @author 谭永波
     */
    @RequestMapping("/findPassword")
    @ResponseBody
    public Result findPassword(String phone,String password){
        return tblUserService.upUserPassword(password,phone);
    }


}
