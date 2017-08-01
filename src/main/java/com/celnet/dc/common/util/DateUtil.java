package com.celnet.dc.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;

/**
 * Created by 秦凯 on 2015/12/17.
 */
public class DateUtil {


    /**
     * 格式化时间
     * yyyy-MM-dd HH:mm:ss
     */
    public static String turnDateToString1(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.formatDefaultTimestamp);//"yyyy-MM-dd HH:mm:ss"
        return sdf.format(date);
    }

    /**
     * 格式化时间
     * yyyyMMdd
     */
    public static String turnDateToString2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_yyyyMMdd);//yyyyMMdd
        return sdf.format(date);
    }

    /**
     * 格式化时间
     * yyyyMMdd
     */
    public static String turnDateToString3(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_yyyyMMdd_bias);//"yyyy/MM/dd"
        return sdf.format(date);
    }

    /**
     * 格式化时间
     * yyyyMMdd
     */
    public static String turnDateToString4(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_HHMMSS);//"HH:mm:ss"
        return sdf.format(date);
    }

    /**
     * 根据传入格式与日期返回日期类型
     */
    public static Date getDateByStr(String format, String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
        } catch (ParseException e) {
            e.fillInStackTrace();
        }
        return calendar.getTime();
    }

    /**
     * 根据传入格式与日期与增加天数返回日期类型
     */
    public static String getStringDateByStr(String format, String date, int add) {
        DateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
            calendar.add(Calendar.DAY_OF_MONTH, add);
        } catch (ParseException e) {
            e.fillInStackTrace();
        }
        return df.format(calendar.getTime());
    }

    /**
     * 根据传入格式与日期与增加天数返回日期类型
     */
    public static Date getDateByDay(Date date, int add) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, add);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return calendar.getTime();
    }

    /**
     * 根据传入格式与日期与增加天数返回日期类型
     */
    public static Date getDateByMinute(Date date, int add, int second) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, add);
            calendar.set(Calendar.SECOND, second);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return calendar.getTime();
    }

    /**
     * 根据传入格式与日期与增加小时数返回日期类型
     */
    public static String getStringDateByAddHours(String format, String date, int add) {
        DateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
            calendar.add(Calendar.HOUR_OF_DAY, add);
        } catch (ParseException e) {
            e.fillInStackTrace();
        }
        return df.format(calendar.getTime());
    }

    /**
     * 根据传入格式与日期与增加分钟数返回日期类型
     */
    public static String getStringDateByAddMinute(String format, String date, int add) {
        DateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(df.parse(date));
            calendar.add(Calendar.MINUTE, add);
        } catch (ParseException e) {
            e.fillInStackTrace();
        }
        return df.format(calendar.getTime());
    }

    /**
     * 当前格式化时间
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.formatDefaultTimestamp);//"yyyy-MM-dd HH:mm:ss
        return sdf.format(new Date());
    }

    /**
     * 当前格式化时间
     * yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentMillisecond() {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_yyyy_MM_dd_HHmmssSSS);//"yyyy-MM-dd HH:mm:ss.SSS"
        return sdf.format(new Date());
    }

    /**
     * 把日期时间格式化为指定格式，如：yyyy-MM-dd HH:mm
     *
     * @param dt         java.util.Date
     * @param formatType : 指定日期转化格式字符串模板,例如:yyyy-MM-dd
     * @return 格式化后的日期时间字符串
     */
    public static String formatDateTime(Date dt, String formatType) {
        String newDate = "";
        if (dt != null) {
            Locale locale = Locale.CHINESE;
            SimpleDateFormat dateStyle = new SimpleDateFormat(formatType, locale);
            newDate = dateStyle.format(dt);
        }
        return newDate;
    }

    /**
     * 获得某天的0点
     *
     * @param date
     * @param formatType
     * @return
     */
    public static String getFormatDateBegin(Date date, String formatType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return formatDateTime(calendar.getTime(), formatType);
    }

    /**
     * 获得某天的23点59分59秒
     *
     * @param date
     * @param formatType
     * @return
     */
    public static String getFormatDateEnd(Date date, String formatType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return formatDateTime(calendar.getTime(), formatType);
    }

    /**
     * 获得某天的0点
     * @param date
     * @return
     */
    public static Date getFormatDateBegin(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        } else {
            return null;
        }

    }

    /**
     * 获得某天的23点59分59秒
     *
     * @param date
     * @return
     */
    public static Date getFormatDateEnd(Date date) {
        if (date != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.MILLISECOND, -1);
            return calendar.getTime();
        } else {
            return null;
        }
    }

    /**
     * 求两个日期差
     *
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期相差天数
     */
    public static long getDateMargin(Date beginDate, Date endDate) {
        long margin = 0;
        margin = endDate.getTime() - beginDate.getTime();
        margin = margin / (1000 * 60 * 60 * 24);
        return margin;
    }

    public static long getDateMarginSecond(Date beginDate, Date endDate) {
        long margin = 0;
        margin = endDate.getTime() - beginDate.getTime();
        margin = margin / 1000;
        return margin;
    }

    /**
     * 校验时间格式是否是需要的格式
     *
     * @param date
     * @param format
     * @return
     */
    public static boolean checkDateFormater(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date tmpDate = sdf.parse(date);
            return date.equals(sdf.format(tmpDate));
        } catch (ParseException e) {
            System.out.print("1");
            return false;
        }
    }

    /**
     * 功能：判断字符串是否为日期格式
     *支持的格式为“YYYY-MM-DD HH:mm:ss”和“YYYY-MM-DD”。
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern.compile(
            "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 格式化时间
     * yyyy
     */
    public static String turnDateToString5(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_yyyy);//"yyyy"
        return sdf.format(date);
    }

    /**
     * 格式化时间
     * MM-dd
     */
    public static String turnDateToString6(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_MM_dd);//"MM-dd"
        return sdf.format(date);
    }

    /**
     * 判断某一时间是否在一个区间内
     *
     * @param sourceTime
     *            时间区间,半闭合,如[10:00-20:00)
     * @param date 需要判断的时间
     * @return
     * @throws IllegalArgumentException
     */
    public static boolean isInTime(String sourceTime, Date date) {
        String curTime = formatDateTime(date, FinalUtil.format_HHMM);//"HH:mm"
        if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
        if (date == null || !curTime.contains(":")) {
            throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
        }
        String[] args = sourceTime.split("-");
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.format_HHMM);//"HH:mm"
        try {
            long now = sdf.parse(curTime).getTime();
            long start = sdf.parse(args[0]).getTime();
            long end = sdf.parse(args[1]).getTime();
            if (args[1].equals("00:00")) {
                args[1] = "24:00";
            }
            if (end < start) {
                if (now >= end && now < start) {
                    return false;
                } else {
                    return true;
                }
            } else {
                if (now >= start && now < end) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
        }
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(FinalUtil.formatDefaultTimestamp);//"yyyy-MM-dd HH:mm:ss
        Date beforeD = getDateByMinute(new Date(), -25,0);
        String time = sdf.format(beforeD);
        System.out.println(time);
    }
}
