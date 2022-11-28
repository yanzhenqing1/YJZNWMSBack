package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblWarehousingST {

  private long id;
  private long warehousing_order_id;
  private long shop_goods_id;
  private String shop_goods_code;
  private String shop_goods_name;
  private String goods_unit;
  private String goods_unit_desc;
  private long plan_number;
  private java.sql.Timestamp plan_time;
  private long warehousing_number;
  private long more_number;
  private long shortage_number;
  private double unit_price;
  private double tax_unit_price;
  private double rate;
  private double tax;
  private double untaxed_amount;
  private double discount_price;
  private double amount;
  private String del_flag;
  private String create_by;
  private java.sql.Timestamp create_time;
  private String update_by;
  private java.sql.Timestamp update_time;
  private String remark;
  private long dept_id;

  //外部映射字段,
  private String order_code;
  private String order_name;
  private String order_date;
  private String supplier_name;
  private long status;

}
