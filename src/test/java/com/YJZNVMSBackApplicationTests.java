package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class YJZNVMSBackApplicationTests {
    @Autowired


    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
//        System.out.println("1111111111111111111");
//        PageHelper.startPage(1,10);
//        List<Tblstaff> list = tblstaffMapper.selStaff();
//        PageInfo<Tblstaff> pageInfo = new PageInfo<>(list);
//        System.out.println("总页数："+pageInfo.getPageSize());
//        System.out.println("总条数："+pageInfo.getTotal());
    }






    @Test
    public void t2(){
        try{
            String str1 = "2022-08-29T16:00:00.000Z";
            String str2 = "2022-08-31T10:00:00.000Z";
            str1 = str1.replace("T"," ").replace("Z"," ");
            str2 = str2.replace("T"," ").replace("Z"," ");
            SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS ");
            Date date1 = sf1.parse(str1);
            Date date2 = sf1.parse(str2);
            double times = date2.getTime()-date1.getTime();
            double days = (times/1000/60/60/24);
            System.out.println(days);
        } catch (ParseException e) {
        e.printStackTrace();
    }

    }
}