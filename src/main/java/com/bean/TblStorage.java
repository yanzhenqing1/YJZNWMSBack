package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblStorage {

  private long id;
  private String storage_code;
  private String storage_name;
  private String storage_barcode;
  private long reservoir_id;
  private String storage_type;
  private String storage_attribute;
  private long storage_size_id;
  private String outbound;
  private String is_empty;
  private String is_disable;
  private String del_flag;
  private String create_by;
  private java.sql.Timestamp create_time;
  private String update_by;
  private java.sql.Timestamp update_time;
  private String remark;
  private long dept_id;


}
