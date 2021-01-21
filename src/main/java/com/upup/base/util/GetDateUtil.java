package com.upup.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换时间/获取时间/时间管理
 */
public class GetDateUtil  {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    public static SimpleDateFormat getSdf() {
        return sdf;
    }
    public static void setSdf(SimpleDateFormat sdf) {
        GetDateUtil.sdf = sdf;
    }

    public static Date getDate() throws ParseException {
        return sdf.parse(getStringDate());
    }

    public static String getStringDate(){
        return sdf.format(new Date());
    }

    public static Date stringOfDate(String formatDate) throws ParseException {
        return sdf.parse(formatDate);
    }

    public static String getStringDateByTime(Long time){
        return sdf.format(new Date(time));
    }
}
