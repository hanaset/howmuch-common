package com.how.muchcommon.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeHelper {
    public static final String DEFAULT_TIMEZONE = "UTC";
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /*
     * String 데이터로부터 LocalDateTime 형식으로 변환하는 함수
     * 단순한 형식 변환 함수
     * Zone 데이터는 없음 - String 자체를 Local로 인식
     */
    public static LocalDateTime convertFromStringDate(String strDate) {
        return LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    /*
     * String 데이터로부터 ZonedDateTime 형식으로 변환하는 함수
     * 단순한 형식 변환 함수
     * toZone 값이 있는 경우는 해당 Zone으로 지정하고 없으면 UTC로 지정
     */
    public static ZonedDateTime getZonedDateTimeFromStringDate(String strDate, String setZone) {
        LocalDateTime dateTime = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));

        ZoneId zoneId = ZoneId.of("UTC");
        if (StringUtils.isNoneEmpty(setZone))
            zoneId = ZoneId.of(setZone);

        return dateTime.atZone(zoneId);
    }

    /*
     * String 데이터로부터 ZonedDateTime 형식으로 변환하는 함수
     * 단순한 형식 변환 함수
     * toZone 값이 있는 경우는 해당 Zone으로 지정하고 없으면 UTC로 지정
     */
    public static ZonedDateTime getZonedDateTimeFromStringDateFormat(String strDate, String format, String setZone) {
        LocalDateTime dateTime = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(format));

        ZoneId zoneId = ZoneId.of("UTC");
        if (StringUtils.isNoneEmpty(setZone))
            zoneId = ZoneId.of(setZone);

        return dateTime.atZone(zoneId);
    }

    public static ZonedDateTime getZonedDateFromStringDateFormat(String strDate, String format, String setZone) {
        LocalDate dateTime = LocalDate.parse(strDate, DateTimeFormatter.ofPattern(format));

        ZoneId zoneId = ZoneId.of("UTC");
        if (StringUtils.isNoneEmpty(setZone)) {
            return ZonedDateTime.of(dateTime, LocalTime.MIN, ZoneId.of(setZone));
        }
        return ZonedDateTime.of(dateTime, LocalTime.MIN, zoneId);


    }

    /*
     * ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
     * String dateStr = DateTimeHelper.getDateStrFromZone("yyyy-MM-dd", now);
     * Result : dateStr --> "2019-05-05"
     */
    public static String getDateStrFromZone(String format, ZonedDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String formattedString = dateTime.format(formatter);

        return formattedString;
    }

    public static ZonedDateTime getZonedDateTimeFromStringDate(String strDate, String fromTimeZone, String toTimeZone) {
        String convertDateStr = getTimezoneDateStr(strDate, fromTimeZone, toTimeZone);

        if (StringUtils.isEmpty(convertDateStr))
            return null;

        return getZonedDateTimeFromStringDate(convertDateStr, toTimeZone);
    }

    public static ZonedDateTime currentTime() {
        return getZonedDateTimeFromStringDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)), ZoneId.systemDefault().getId());
    }


    /*
     * 현재 시스템에서 toZone에 해당하는 시간을 ZonedDateTime으로 리턴
     */
    public static ZonedDateTime currentTime(String toZone) {
//        String currentTime =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//        return getZonedDateTimeFromStringDate(currentTime, ZoneId.systemDefault().getId(), toZone);
        return currentTime(toZone, "yyyy-MM-dd HH:mm:ss");
    }

    public static ZonedDateTime currentTime(String toZone, String format) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));


        return getZonedDateTimeFromStringDate(currentTime, ZoneId.systemDefault().getId(), toZone);
    }

    /*
     * UTC Zone 타임 리턴
     */
    public static ZonedDateTime currentUTCTime() {
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

    /*
     * 주어진 DateTime String 을 fromTimeZone으로 보고 toTimeZone으로 변경
     */
    public static String getTimezoneDateStr(String dateStr, String fromTimeZone, String toTimeZone) {
        String currentTimeStr = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone(fromTimeZone));

        Date date;
        try {
            date = dateFormat.parse(dateStr);

            dateFormat.setTimeZone(TimeZone.getTimeZone(toTimeZone));
            currentTimeStr = dateFormat.format(date);
        } catch (Exception ex) {
            // ex.printStackTrace();
        }

        return currentTimeStr;
    }

    public static ArrayList<Date> getWeekendsInYear() {

        ArrayList<Date> weekendList = new ArrayList();

        Calendar cal = new GregorianCalendar(getCurrentYear(), Calendar.JANUARY, 1);

        // The while loop ensures that you are only checking dates in the current year
        while (cal.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            // The switch checks the day of the week for Saturdays and Sundays
            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:
                    weekendList.add(cal.getTime());
                    break;
            }
            // Increment the day of the year for the next iteration of the while loop
            cal.add(Calendar.DAY_OF_YEAR, 1);
        }

        return weekendList;
    }

    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();


        return calendar.get(Calendar.MONTH);
    }

    public static int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();

        return calendar.get(Calendar.YEAR);
    }


    public static ZonedDateTime dateTimeAgo(int hour, int min, int sec) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.HOUR, -hour);
        calendar.add(Calendar.MINUTE, -min);
        calendar.add(Calendar.SECOND, -sec);

        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static ZonedDateTime monthAgo(int month) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MONTH, -month);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }


    public static ZonedDateTime hoursAgo(int hour) {
        Calendar calendar = Calendar.getInstance();


        calendar.add(Calendar.HOUR, -hour);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static ZonedDateTime hoursAfter(String format, int hour) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.HOUR, hour);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static ZonedDateTime hoursAfter(int hour) {
        return hoursAfter(DEFAULT_DATE_FORMAT, hour);
    }

    public static ZonedDateTime dayAgo(String format, int day) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_MONTH, -day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }


    public static ZonedDateTime dayAfter(String format, int day) {
        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static ZonedDateTime dayAfter(int day) {
        return dayAfter(DEFAULT_DATE_FORMAT, day);
    }

    public static ZonedDateTime minutesAgo(int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -min);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static ZonedDateTime secondsAgo(int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -sec);
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return getZonedDateTimeFromStringDate(sdf.format(calendar.getTime()), ZoneId.systemDefault().getId(), DEFAULT_TIMEZONE);
    }

    public static String getCurrentTimeStr() {
        String currentTimeStr;

        DateFormat dateFormat = createSdf("[yyyy/MM/dd HH:mm:ss]", null);
        currentTimeStr = dateFormat.format(new Date());
        return currentTimeStr;
    }

    public static String getCurrentTimeStr(String format, String timeZone) {
        String currentTimeStr;

        DateFormat dateFormat = createSdf(format, timeZone);
        currentTimeStr = dateFormat.format(new Date());
        return currentTimeStr;
    }

    public static ZonedDateTime getZonedDateTime(Long timestamp) {
        return getZonedDateTime(timestamp, "UTC");
    }

    public static ZonedDateTime getZonedDateTime(Long timestamp, String timeZone) {

        ZoneId zoneId = ZoneId.of("UTC");
        if (StringUtils.isNoneEmpty(timeZone))
            zoneId = ZoneId.of(timeZone);

        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(timestamp), zoneId);
    }

    public static Long getTimestamp(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null)
            return zonedDateTime.toEpochSecond();

        return null;
    }

    private static DateFormat createSdf(String sdfFormat, String timeZone) {
        DateFormat dateFormat = new SimpleDateFormat(sdfFormat);
        if (!StringUtils.isEmpty(timeZone))
            dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        else
            dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault().getId()));

        return dateFormat;
    }

    public static String formatMillis(long val) {
        StringBuilder buf = new StringBuilder(20);
        String sgn = "";

        if (val < 0) {
            sgn = "-";
            val = Math.abs(val);
        }

        append(buf, sgn, 0, (val / 3600000));
        val %= 3600000;
        append(buf, ":", 2, (val / 60000));
        val %= 60000;
        append(buf, ":", 2, (val / 1000));
        val %= 1000;
        append(buf, ".", 3, (val));
        return buf.toString();
    }

    private static void append(StringBuilder tgt, String pfx, int dgt, long val) {
        tgt.append(pfx);
        if (dgt > 1) {
            int pad = (dgt - 1);
            for (long xa = val; xa > 9 && pad > 0; xa /= 10) {
                pad--;
            }
            for (int xa = 0; xa < pad; xa++) {
                tgt.append('0');
            }
        }
        tgt.append(val);
    }
}
