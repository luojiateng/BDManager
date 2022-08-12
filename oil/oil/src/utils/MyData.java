package utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyData {

    /**
     * 数据库时间与Java util的时间转换
     */
    public static java.sql.Date caseTime(String time) {
        DateFormat dateFormat;
        //规定格式
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);//取消宽松检查
        java.util.Date timeDate = null;//util类型
        try {
            timeDate = dateFormat.parse(time);//解析规定格式的字符串成为Java.util.Date类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//将util类型的Date转化为sql类型
        return dateTime;
    }

}
