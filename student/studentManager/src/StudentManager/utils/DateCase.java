package StudentManager.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 将指定格式的时间字符串转化为sql的data格式
 */
public class DateCase {
    public static java.sql.Date caseTime(String time) {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        dateFormat.setLenient(false);
        java.util.Date timeDate = null;//util类型
        try {
            timeDate = dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());//sql类型
        return dateTime;
    }
}
