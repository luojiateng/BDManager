package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 数据库时间和Java时间转换工具类
 */
public class MyDate {
    public static java.sql.Date CaseTime(String time) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);
        java.util.Date timeDate = null;//将时间字符串转化为util Date类型
        try {
            timeDate = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
        return dateTime;
    }
}
