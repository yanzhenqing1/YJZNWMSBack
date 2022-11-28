package com.service;

import com.bean.TblAppUser;
import com.bean.TblWarehouse;
import com.bean.TblWarehousingST;
import com.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface WMSService {

    //获取待分拣列表
    public List<TblWarehousingST> getSortedList();
    //获取仓库列表
    public List<TblWarehouse> getWarehouseList();
}
