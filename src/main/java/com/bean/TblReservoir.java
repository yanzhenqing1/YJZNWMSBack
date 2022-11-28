package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblReservoir {

  private long id;
  private String reservoir_code;
  private String reservoir_name;
  private long warehouse_id;
  private String del_flag;
  private String create_by;
  private java.sql.Timestamp create_time;
  private String update_by;
  private java.sql.Timestamp update_time;
  private String remark;
  private long dept_id;

}
