package com.itheima.utils;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String,Date> {

    private String[] dfs={"yyyy-MM-dd","yyyy/MM/dd"};
    @Nullable
    @Override
    public Date convert(String s) {
        Date date=null;
        DateFormat sdf=null;
        for (String df : dfs) {
            sdf = new SimpleDateFormat(df);
            try {
                date=sdf.parse(s);
            } catch (ParseException e) {
                System.out.println("转换失败,正在尝试其他方式!" + e.getMessage());
            }
        }
        return date;
    }
}
