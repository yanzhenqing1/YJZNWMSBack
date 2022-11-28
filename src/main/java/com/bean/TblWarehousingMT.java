package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TblWarehousingMT {

  private long id;
  private String orderType;
  private String orderCode;
  private String orderName;
  private java.sql.Date orderDate;
  private long supplierId;
  private String supplierName;
  private long warehouseId;
  private long desWarehouseId;
  private String desWarehouseName;
  private double rate;
  private double tax;
  private double discountRate;
  private double discountAmount;
  private double discountPrice;
  private double otherFee;
  private double untaxedAmount;
  private double totalAmount;
  private String status;
  private long outboundOrderId;
  private String delFlag;
  private String createBy;
  private java.sql.Timestamp createTime;
  private String updateBy;
  private java.sql.Timestamp updateTime;
  private String remark;
  private long deptId;


}
