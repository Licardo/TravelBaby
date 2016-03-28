package com.miaotu.travelbaby.utils;


import org.apache.commons.lang3.time.DurationFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import la.ruru.ui.MainApplication;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 13-10-30
 * Time: 下午2:53
 * To change this template use File | Settings | File Templates.
 */
public class TimeUtil {
    public static String now() {
        Date date = new Date(System.currentTimeMillis()+ MainApplication.getTimeGap());
        return dateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String today() {
        Date date = new Date(System.currentTimeMillis()+ MainApplication.getTimeGap());
        return dateToString(date, "yyyy-MM-dd");
    }

    // 如果是当天 只显示具体时间  非当天显示日期部分
    public static String processTime(String timeStr) {
        String today = today();
        if (timeStr.contains(today)) {
            return timeStr.replace(today, "");
        } else {
            return timeStr.substring(0,10);
        }
    }


    public static String monthsBetween(Date start, Date end) {
        String result = "";
        Calendar cstart = Calendar.getInstance();
        Calendar cend = Calendar.getInstance();
        cstart.setTime(start);
        cend.setTime(end);
        Calendar ctemp = Calendar.getInstance();
        ctemp.setTime(end);
        ctemp.add(Calendar.DATE, 1);
        int totalMonth = 0;
        int year = cend.get(Calendar.YEAR) - cstart.get(Calendar.YEAR);
        int month = cend.get(Calendar.MONTH) - cstart.get(Calendar.MONTH);
        if ((cstart.get(Calendar.DATE) == 1) && (ctemp.get(Calendar.DATE) == 1)) {
            totalMonth = (year * 12 + month + 1);
        } else if ((cstart.get(Calendar.DATE) != 1) && (ctemp.get(Calendar.DATE) == 1)) {
            totalMonth = (year * 12 + month);
        } else if (cstart.get(Calendar.DATE) == 1 && ctemp.get(Calendar.DATE) != 1) {
            totalMonth = (year * 12 + month);
        } else {
            totalMonth = (year * 12 + month - 1) < 0 ? 0 : (year * 12 + month);
        }

        int totalYear = totalMonth / 12;
        int leftMonth = totalMonth - totalYear * 12;
        if (totalYear == 0 && leftMonth != 0) {
            result = leftMonth + "个月了";
        } else if (totalYear != 0 && leftMonth == 0) {
            result = totalYear + "岁了";
        }
        if (totalYear != 0 && leftMonth != 0) {
            result = totalYear + "岁" + leftMonth + "个月了";

        } else if (totalYear == 0 && leftMonth == 0) {
            result = "还没满月呢";
        }


        return result;
    }


    /**
     * 将出生日期和接种月龄相加，与现在时间比较
     *
     * @param birth
     * @param days
     * @return
     */
    public static boolean isDatePassed(String birth, int days) {
        boolean result = false;
        Date birthDate;
        try {
            birthDate = stringToDate(birth, "yyyy-MM-dd");
            Calendar cstart = Calendar.getInstance();
            cstart.setTime(birthDate);
            cstart.add(Calendar.DATE, days);
            int dayNum = timeSpan(new Date(), cstart.getTime(), 0);
//            Log.i("pass? ",birth + " " + days+"  "+cstart.getTime()+  "  "+dayNum);
            result = dayNum >= 1;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 提前五秒钟以上才算不过期
     *
     * @param orgDate
     * @param timePart
     * @return
     */
    public static boolean isDateTimePassed(Date orgDate, String timePart) {
        final SimpleDateFormat fmt = new SimpleDateFormat();
        final Calendar c = Calendar.getInstance();
        final long now = System.currentTimeMillis();

        // 设置开始时间
        try {
            c.setTime(orgDate);

            fmt.applyPattern("HH:mm");
            Date d2 = fmt.parse(timePart);
            c.set(Calendar.HOUR_OF_DAY, d2.getHours());
            c.set(Calendar.MINUTE, d2.getMinutes());
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //提前五秒钟以上才算不过期
        return now - c.getTimeInMillis() >= 1000 * 5;

    }

    public static String numToNumCH(int num) {
        String numCh = "";
        if (num == 1) {
            numCh = "一";
        } else if (num == 2) {
            numCh = "二";
        } else if (num == 3) {
            numCh = "三";
        } else if (num == 4) {
            numCh = "四";
        }
        return numCh;
    }


    /* 格式化字符串(7:3->07:03) */
    public static String dateTimeformat(int x) {
        String s = "" + x;
        if (s.length() == 1)
            s = "0" + s;
        return s;
    }


    public static Date afterNMinute(Date date, int n) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setTime(date);

        c.add(Calendar.MINUTE, n);
        Date d2 = c.getTime();

        return d2;
    }

    public static String afterNMinute_String(Date date, int n) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setTime(date);

        c.add(Calendar.MINUTE, n);
        Date d2 = c.getTime();
        String s = df.format(d2);
        return s;
    }

    public static String afterNDay_String(Date date, int n) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c.setTime(date);
        c.add(Calendar.DATE, n);
        Date d2 = c.getTime();
        String s = df.format(d2);
        return s;
    }

    public static String afterNDay_StringSimple(String dateStr, int n) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateStr);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, n);
        Date d2 = c.getTime();
        String s = df.format(d2);
        return s;
    }

    public static Date stringToDate(String dateStr) {
        String formatStr = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat ds = new SimpleDateFormat(formatStr, Locale.CHINA);
        Date date=null;
        try {
            date= ds.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date stringToDate(String dateStr, String formatStr) throws ParseException {
        SimpleDateFormat ds = new SimpleDateFormat(formatStr, Locale.CHINA);
        return ds.parse(dateStr);

    }

    public static String dateToString(Date date, String formatStr) {
        // formatStr    "yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat ds = new SimpleDateFormat(formatStr, Locale.CHINA);
        return ds.format(date);
    }


    /**
     * @param dateNew
     * @param date
     * @param type    0天 ,1小时 ,2分钟 ,3秒
     * @return
     */
    public static int timeSpan(Date dateNew, Date date, int type) {
        int result = 0;
        if (dateNew.after(date)) {
            long seconds = (dateNew.getTime() - date.getTime()) / 1000;

            if (type == 0) {
                long day = seconds / (3600 * 24);
                result = Integer.parseInt(String.valueOf(day));
            } else if (type == 1) {
                long hour = seconds / 3600;
                result = Integer.parseInt(String.valueOf(hour));
            } else if (type == 2) {
                long minute = seconds / 60;
                result = Integer.parseInt(String.valueOf(minute));
            }
            if (type == 3) {
                result = Integer.parseInt(String.valueOf(seconds));
            }
        }
        return result;
    }


    public static String leftTime(Date from, Date to) {
        if (to.after(from)) {
            String timeStr = DurationFormatUtils.formatPeriod(from.getTime(), to.getTime(), "d'天'HH'小时'mm'分钟'ss'秒'");
            //0天07小时59分钟59秒
            //0天00小时29分钟59秒
            timeStr = timeStr.replace("0天", "").replace("00小时", "").replace("00分钟", "");
            System.out.println("还剩：" + timeStr);
            return timeStr;
        } else {
            return "";

        }
    }


    public static String leftTimeMinute(Date from, Date to) {
        if (to.after(from)) {
            String timeStr = DurationFormatUtils.formatPeriod(from.getTime(), to.getTime(), "d'天'HH'小时'mm'分钟'ss'秒'");
            //0天07小时59分钟59秒
            //0天00小时29分钟59秒
            timeStr = timeStr.replace("0天", "").replace("00小时", "").replace("00分钟", "");
//            System.out.println("还剩：" + timeStr);
            return timeStr;
        } else {
            return "";

        }
    }

    public static void main(String[] args) {
        System.out.println("test ");
        Date date = new Date();
        Date newDate = afterNMinute(date, -1);
//        System.out.println(dateToString(newDate,"yyyyMMddHHmmss"));
        String t1 = "2015-09-07 10:20:14";
        String t2 = "2015-09-07 10:20:13";

//        System.out.println(t1.compareTo(t2));

        leftTime(new Date(), newDate);
//        0天07小时59分钟59秒
//        0天00小时29分钟59秒

    }

    public static SimpleDateFormat serverFormat = new SimpleDateFormat("yyyyMMddHHmmss",
            Locale.getDefault());

    public static Date getServerTimeDate(String serverTimeStr) {
        if (serverTimeStr == null || "".equals(serverTimeStr))
            return null;
        Date ctime = null;
        try {
            serverFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            ctime = serverFormat.parse(serverTimeStr);
        } catch (final ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ctime;
    }
    // 时间戳格式转换
    public static String getChatTime(Date date) {
        String result = "";
        final SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.getDefault());
        final Date today = new Date(System.currentTimeMillis());
        final int temp = Integer.parseInt(sdf.format(today))
                - Integer.parseInt(sdf.format(date));
        switch (temp) {
            case 0:
                result = "今天 " + getHourAndMin(date);
                break;
            case 1:
                result = "昨天 " + getHourAndMin(date);
                break;
            case 2:
                result = "前天 " + getHourAndMin(date);
                break;

            default:
                result = getTime(date);
                break;
        }
        return result;
    }


    public static String getHourAndMin(Date date) {
        final SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return format.format(date);
    }
    public static String getTime(Date date) {
        final SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
        return format.format(date);
    }
}
