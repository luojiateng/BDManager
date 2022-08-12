package com.kaizi.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert {
    /**
     *把yyyy-MM-dd格式的字符串转换为日期
     * @param str
     * @return
     */
    public static Date  convertToDate(String str) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 把字符串转换为指定格式的日期
     * @param str
     * @param pattern
     * @return
     */
    public static Date convertToDate(String str, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 把日期转换为yyyy-MM-dd格式的字符串
     * @param date
     * @return
     */
    public static String convertToString(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }
    /**
     * 把日期转换为指定格式的字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String convertToString(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat();
        return df.format(date);
    }
}
