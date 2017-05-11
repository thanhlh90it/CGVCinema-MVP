package com.thanhlh.cinema.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by thanhle on 4/24/17.
 */

public class DateUtils {
    public static final String OUT_DATE_FORMAT = "dd/MM/yyyy";
    public static final String IN_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";//2017-04-28 00:00:00

    /**
     * parse date to string
     * @param date
     * @param pattern
     * @return
     */
    public static String parseDateToString(Date date, String pattern) {
        return date != null && pattern != null ? new SimpleDateFormat(pattern).format(date) : null;
    }

    /**
     * Parse String To Date
     * @param data
     * @param pattern
     * @return
     */
    public static Date parseStringToDate(String data, String pattern) {
        Date date = null;
        if(StringUtils.isEmptyString(data))
            return date;
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            date = formatter.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
