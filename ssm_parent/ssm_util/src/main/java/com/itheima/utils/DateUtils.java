package com.itheima.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String DatetoString(Date departureTime, String s) {

        SimpleDateFormat sdf = new SimpleDateFormat(s);

        String format = sdf.format(departureTime);

        return format;
    }
}
