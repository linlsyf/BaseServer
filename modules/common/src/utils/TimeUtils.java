package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
       public static int  getCurrentYear(){
           Calendar cal = Calendar.getInstance();
           int year = cal.get(Calendar.YEAR);
           return year;
       }

       public  static Date parseTime( String  time){
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

           Date date = null;
           try {
               // 注意格式需要与上面一致，不然会出现异常
               date = sdf.parse(time);
           } catch (ParseException e) {
               e.printStackTrace();
           }
           return date;

       }
    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
}
