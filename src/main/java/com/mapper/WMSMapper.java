package com.mapper;

import com.bean.TblReservoir;
import com.bean.TblWarehousingST;
import com.bean.TblWarehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WMSMapper {

    //获取待分拣列表
    public List<TblWarehousingST> getSortedList();
    //获取仓库列表
    public List<TblWarehouse> getWarehouseList();
    //获取库区列表
    public List<TblReservoir> getReservoirList();

}
