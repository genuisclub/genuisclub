package club.genuis.web.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /**
     * 获取年份和周的组合
     * 例如 2021-7-26是第31周， 则返回202131
     * @return
     */
    public static int getWeekCount(){
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int week = cal.get(Calendar.WEEK_OF_YEAR);
        return Integer.parseInt(year+""+week);
    }

    public static String getWeekCountStr(){
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int week = cal.get(Calendar.WEEK_OF_YEAR);
        return String.format("%d%02d",year,week);
    }

    /**
     * 获取年份和周的组合
     * 例如 2021-7-26是第31周， 则返回202107
     * @return
     */
    public static String getMonthCount(){
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        final int month = cal.get(Calendar.MONTH)+1;
        return String.format("%d%02d",year,month);
    }

    public static String getYear(){
        Calendar cal = Calendar.getInstance();
        final int year = cal.get(Calendar.YEAR);
        return String.format("%d",year);
    }

    /**
     * 当前还剩余的秒数
     * @return
     */
    public static long getRemainderSecond(){
        //当前秒数
        long curInMillis = System.currentTimeMillis();
        //需要当天晚上24点的秒数
        Calendar calendar = Calendar.getInstance();
        //日期添加一天
        calendar.add(Calendar.DAY_OF_YEAR,1);
        //小时数设置为0
        calendar.set(Calendar.HOUR_OF_DAY,0);
        //分钟数设置0
        calendar.set(Calendar.MINUTE,0);
        //秒数设置0
        calendar.set(Calendar.SECOND,0);
        //毫秒数设置0
        calendar.set(Calendar.MILLISECOND,0);
        //晚上24点的时间戳
        long timeInMillis = calendar.getTimeInMillis();
        //两个时间相减
        return (timeInMillis-curInMillis)/1000;
    }


    public static Date add(Date start, int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.add(Calendar.DAY_OF_YEAR,days);
        return calendar.getTime();
    }

    public static String getYmdh(){
        SimpleDateFormat yyyymmddhh = new SimpleDateFormat("yyyyMMddHH");
        return yyyymmddhh.format(new Date());
    }
    public static String getYmd(){
        SimpleDateFormat yyyymmddhh = new SimpleDateFormat("yyyyMMdd");
        return yyyymmddhh.format(new Date());
    }

    public static String getYmdhms(){
        SimpleDateFormat yyyymmddhh = new SimpleDateFormat("yyyyMMddHHmmss");
        return yyyymmddhh.format(new Date());
    }

    public static long getReachInSecond(Date date){
        long cur = System.currentTimeMillis();
        long target = date.getTime();
        long res = target - cur;
        if(res < 0)return 0;
        return res/1000;
    }

    public static int getNextCellTime(){
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int curSec = hour*3600+min*60+sec;
        if(hour < 8){
            return 8*3600 - curSec;
        }
        if(hour<16){
            return 16*3600 -curSec;
        }
        return 24*3600-curSec;
    }

    public static Date getToday(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        return cal.getTime();
    }
    public static Date getYesterday(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.add(Calendar.DAY_OF_YEAR,-1);
        return cal.getTime();
    }

    public static long calcDaysBetween(Date start, Date end){
        return (end.getTime() - start.getTime())/(1000*3600*24);
    }

    public static void main(String[] args) {
        System.out.println(String.format("%d%02d",2031,4));
    }
}
