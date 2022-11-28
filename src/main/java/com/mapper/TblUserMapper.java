package com.mapper;

import com.bean.TblAppUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblUserMapper  {

    //根据phone查找用户
    public TblAppUser findAppUser(String phone);
    //用户注册
    public boolean userRegister(String loginName,
                                   String trueName,
                                   String phone,
                                   String password,
                                   String salt,
                                   String createDate);
    //用户修改/忘记密码
    public int upUserLoginInfo(String sex,
                               String avatar,
                               String loginIp,
                               String loginDate,
                               String password,
                               String salt,
                               String phone,
                               String upDate);

}
