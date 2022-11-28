package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblAppUser {
    private String user_id;
    private String dept_id;
    private String login_name;
    private String user_name;
    private String user_type;
    private String email;
    private String phonenumber;
    private String sex;
    private String avatar;
    private String password;
    private String salt;
    private String status;
    private String del_flag;
    private String login_ip;
    private String login_date;
    private String pwd_update_date;
    private String create_by;
    private String create_time;
    private String update_by;
    private String update_time;
    private String remark;
}
