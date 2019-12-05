package utils;


import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/3/7 0007.
 */

public class TimeAreaUtils {
    public static String getYesDayString(){
        Date d=new Date(System.currentTimeMillis()-1000*60*60*24);
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String yesday=sp.format(d);//获取昨天日期
        return  yesday;

    }
    public static String getTimeNow(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
       String   time=dateFormat.format(date);
        return  time;

    }
}
