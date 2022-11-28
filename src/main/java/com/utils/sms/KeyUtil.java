package com.utils.sms;

import java.util.Random;

/**
 * 用来生产验证码
 */

public class KeyUtil {
    public static String keyCode(){
        StringBuffer str = new StringBuffer();
        Random ran = new Random();
        for (int i=0; i<4;i++){
            int num = ran.nextInt(9);
            str.append(num);
        }
        return String.valueOf(str);
    }

}
