package com.example.yiqian.accountingapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yiqian on 2018/4/11.
 */

public class DateUtil {

    //unix time to 11:11
    public static String getFormattedTime(long timeStamp){

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(new Date(timeStamp));

    }

    public static String getFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }
}
