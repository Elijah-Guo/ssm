package com.itheima.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String,Date> {

    private static String[] dfs = {"yyyy-MM-dd","yyyy/MM/dd"};

    public Date convert(String s) {
        // 创建方法的返回值
        Date date = null;
        DateFormat dateFormat = null;
        if(!StringUtils.isEmpty(s)){
            for (String df : dfs) {
                dateFormat = new SimpleDateFormat(df);
                try {
                    date = dateFormat.parse(s);
                } catch (ParseException e) {
                    System.out.println("转换失败,正在尝试其他方式!" + e.getMessage());
                }
            }
        }
        // 返回
        return date;
    }
}
