package com.upup.sys.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        Date parse = sdf.parse(sdf.format(new Date()));
//        System.out.println();// new Date()为获取当前系统时间
        String className = "om.upup.sys.controller.SysLogController";
        String nameController = className.substring(className.lastIndexOf("."), className.length());
        String nameController2 = nameController.substring(1, nameController.lastIndexOf("Controller"));

//        System.out.println();
    }
}
