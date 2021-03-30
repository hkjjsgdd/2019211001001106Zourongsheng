package com.zourongsheng.week4.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUitil {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public static java.util.Date StrToUtil(String str){
        try {
            java.util.Date date =  sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static java.sql.Date UtilToSql(java.util.Date date){

        return new java.sql.Date(date.getTime());
    }
    public static String utilToStr(java.util.Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
