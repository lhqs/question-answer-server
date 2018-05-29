package cn.lhqs.middle.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * author : lhqs
 * description : 时间工具类， 用于时间的格式化及計算處理
 * createTime : 2017-10-24 16:09
 * version : 1.0
 */
public class TimeTools {
    public static final String DATE_TYPE1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TYPE2 = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATE_TYPE3 = "yyyyMMddHHmmssSSS";

    public static final String DATE_TYPE4 = "yyyyMMddHHmmss";

    public static final String DATE_TYPE5 = "yyyy-MM-dd";

    public static final String DATE_TYPE6 = "yy-MM-dd-HH-mm-ss";

    public static final String DATE_TYPE7 = "yyyy-MM-dd HH:mm";

    public static final String DATE_TYPE8 = "yyyyMMdd";

    public static final String DATE_TYPE9 = "yyyy-M-d H:m:s:S";

    public static final String DATE_TYPE10 = "yyyyMMddHHmm";

    public static final String DATE_TYPE11 = "yyyy-M-d H:m:s";

    public static final String DATE_TYPE12 = "yy-MM-dd HH:mm:ss";

    public static final String DATE_TYPE13 = "yyyy/MM/dd HH:mm:ss";

    public static final String DATE_TYPE14 = "MM-dd HH:mm:ss";

    public static final String DATE_TYPE15 = "yyyy年MM月dd日 HH:mm";
    public static final String DATE_TYPE16 = "MM月dd日 HH:mm";
    public static final String DATE_TYPE17 = "yyyyMM";
    public static final String DATE_TYPE18 = "HHmm";
    public static final String DATE_TYPE19 = "HHmmss";
    public static final String DATE_TYPE20 = "HHmmssSSS";

    public static TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");// 获取时区

    /**
     * 将date转化为指定格式的字符串
     * @param date
     * @param dataType 格式类型
     * @return
     */
    public static String dateFormat(Date date, String dataType){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dataType);
        return localDateTime.format(dtf);
    }

    public static LocalDateTime dataTypeTransform( String timeStr,String formatTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern(formatTime);
        return LocalDateTime.parse(timeStr,df);
    }

    public static String dateFormatNow( String dataType){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dataType);
        return localDateTime.format(dtf);
    }

}
