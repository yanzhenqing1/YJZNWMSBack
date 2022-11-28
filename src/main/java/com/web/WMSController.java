package com.web;

import com.service.WMSService;
import com.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * vms模块
 * @author 谭永波
 * @version 1.0.1
 */
@Controller
@RequestMapping("/WMS")
public class WMSController {

    @Autowired
    WMSService wmsService;

    /**
     * 获取待分拣列表
     *
     * @author 谭永波
     */
    @RequestMapping("/getSortedList")
    @ResponseBody
    public Result getSortedList(){
        return Result.ok(wmsService.getSortedList());
    }

    /**
     * 获取仓库/货架列表
     *
     * @author 谭永波
     */
    @RequestMapping("/getWarehouseList")
    @ResponseBody
    public Result getWarehouseList(){

        return Result.ok(wmsService.getWarehouseList());
    }

}
