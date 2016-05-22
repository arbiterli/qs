package com.glority.qualityserver.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * Date Utils.
 * 
 * @author liheping
 * 
 */
public final class DateUtils {
    private static final int HOUR_START_VALUE = 0;
    private static final int HOUR_END_VALUE = 23;
    private static final int MINUTE_START_VALUE = 0;
    private static final int MINUTE_END_VALUE = 59;
    private static final int SECOND_START_VALUE = 0;
    private static final int SECOND_END_VALUE = 59;

    /**
     * default constructor.
     */
    private DateUtils() {

    }

    /**
     * get the start time of the date. this method get a new date.
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getDateStartTime(Date date) {
        if (date != null) {
            Date newDate = copyDate(date);
            newDate.setHours(HOUR_START_VALUE);
            newDate.setMinutes(MINUTE_START_VALUE);
            newDate.setSeconds(SECOND_START_VALUE);
            return newDate;
        }
        return null;
    }

    /**
     * get set the date to be the start time of the date.
     * 
     * @param date
     */
    @SuppressWarnings("deprecation")
    public static void setTimeToDateStartTime(Date date) {
        if (date != null) {
            formatDate(date);
            date.setHours(HOUR_END_VALUE);
            date.setMinutes(MINUTE_START_VALUE);
            date.setSeconds(SECOND_START_VALUE);
        }
    }

    /**
     * format all the date in the list to be start time of the date.
     * 
     * @param dateList
     */
    public static void formatDatesToStartTime(List<Date> dateList) {
        if (dateList != null && !dateList.isEmpty()) {
            for (Date date : dateList) {
                setTimeToDateStartTime(date);
            }
        }
    }

    /**
     * get the end of the date, this method get a new date.
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Date getDateEndTime(Date date) {
        if (date != null) {
            Date newDate = copyDate(date);
            newDate.setHours(HOUR_END_VALUE);
            newDate.setMinutes(MINUTE_END_VALUE);
            newDate.setSeconds(SECOND_END_VALUE);
            return newDate;
        }
        return null;
    }

    /**
     * set the date to be the end time of the date.
     * 
     * @param date
     */
    @SuppressWarnings("deprecation")
    public static void setTimeToDateEndTime(Date date) {
        if (date != null) {
            formatDate(date);
            date.setHours(HOUR_END_VALUE);
            date.setMinutes(MINUTE_END_VALUE);
            date.setSeconds(SECOND_END_VALUE);
        }
    }

    /**
     * format all the date in the list to be the end time of date.
     * 
     * @param dateList
     */
    public static void formatDatesToEndTime(List<Date> dateList) {
        if (dateList != null && !dateList.isEmpty()) {
            for (Date date : dateList) {
                setTimeToDateEndTime(date);
            }
        }
    }

    /**
     * get a timestamp for start time of hour, get a new timestamp.
     * 
     * @param sampleTime
     * @return
     */
    @SuppressWarnings("deprecation")
    public static Timestamp getSartTimeOfHour(Timestamp sampleTime) {
        if (sampleTime != null) {
            Timestamp newTime = new Timestamp(copyDate(sampleTime).getTime());
            newTime.setMinutes(MINUTE_START_VALUE);
            newTime.setSeconds(SECOND_START_VALUE);
            return newTime;
        }
        return null;
    }

    /**
     * set the time to be the start time of hour.
     * 
     * @param sampleTime
     */
    @SuppressWarnings("deprecation")
    public static void setTimeToStartTimeOfHour(Timestamp sampleTime) {
        if (sampleTime != null) {
            sampleTime.setTime(copyDate(sampleTime).getTime());
            sampleTime.setMinutes(MINUTE_START_VALUE);
            sampleTime.setSeconds(SECOND_START_VALUE);
        }
    }

    /**
     * find the smallest date in the date list.
     * 
     * @param dateList
     * @return
     */
    public static Date getSmallestDateTime(List<Date> dateList) {
        if (dateList != null && !dateList.isEmpty()) {
            Date smallestDate = dateList.get(0);
            for (Date date : dateList) {
                if (date.before(smallestDate)) {
                    smallestDate = date;
                }
            }
            return smallestDate;
        }
        return null;
    }

    /**
     * find the largest date in the date list.
     * 
     * @param dateList
     * @return
     */
    public static Date getLargestDateTime(List<Date> dateList) {
        if (dateList != null && !dateList.isEmpty()) {
            Date largestDate = dateList.get(0);
            for (Date date : dateList) {
                if (date.after(largestDate)) {
                    largestDate = date;
                }
            }
            return largestDate;
        }
        return null;
    }

    /**
     * generate date list.
     * 
     * @param startTime
     * @param endTime
     * @param interval
     * @return
     */
    public static List<Date> getDateList(Date startTime, Date endTime, int interval) {
        List<Date> result = new ArrayList<Date>();

        if (startTime != null && endTime != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startTime);

            Date tempDay = cal.getTime();
            if (startTime.before(endTime)) {
                while (!tempDay.after(endTime)) {
                    result.add(tempDay);
                    cal.add(Calendar.DATE, interval);
                    tempDay = cal.getTime();
                }
            } else {
                while (!tempDay.before(endTime)) {
                    result.add(tempDay);
                    cal.add(Calendar.DATE, -interval);
                    tempDay = cal.getTime();
                }
            }
        }

        return result;
    }

    /**
     * since Date class do not give the API to set the ms, this method is to set
     * the ms to be 0 for date.
     * 
     * @param date
     * @return
     */
    @SuppressWarnings("deprecation")
    private static Date copyDate(Date date) {
        Date newDate = new Date(0);
        newDate.setYear(date.getYear());
        newDate.setMonth(date.getMonth());
        newDate.setDate(date.getDate());
        newDate.setHours(date.getHours());
        newDate.setMinutes(date.getMinutes());
        newDate.setSeconds(date.getSeconds());
        return newDate;
    }

    /**
     * since Date class do not give the API to set the ms, this method is to set
     * the ms to be 0 for date.
     * 
     * @param date
     */
    private static void formatDate(Date date) {
        Date newDate = copyDate(date);
        date.setTime(newDate.getTime());
    }

    public static Timestamp getTimestamp(String timestampString, String dateFormatString) {
        if (StringUtils.isNotEmpty(timestampString) && StringUtils.isNotEmpty(dateFormatString)) {
            try {
                DateFormat df = new SimpleDateFormat(dateFormatString);
                Date date = df.parse(timestampString);
                return new Timestamp(date.getTime());
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
