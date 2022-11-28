package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblWarehouse {

  private long id;
  private String warehouse_code;
  private String warehouse_name;
  private String city;
  private String address;
  private String principal;
  private String telephone;
  private String del_flag;
  private String create_by;
  private java.sql.Timestamp create_time;
  private String updateBy;
  private java.sql.Timestamp update_time;
  private String remark;
  private long dept_id;


}
