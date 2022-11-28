package com.service.impl;

import com.bean.TblWarehouse;
import com.bean.TblWarehousingST;
import com.mapper.WMSMapper;
import com.service.WMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VMSServicImpl implements WMSService {

    @Autowired
    WMSMapper wmsMapper;

    @Override
    public List<TblWarehousingST> getSortedList(){
        return wmsMapper.getSortedList();
    }

    @Override
    public List<TblWarehouse> getWarehouseList() {
        return wmsMapper.getWarehouseList();
    }
}
