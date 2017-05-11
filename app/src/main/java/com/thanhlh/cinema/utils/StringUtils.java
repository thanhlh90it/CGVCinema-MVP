package com.thanhlh.cinema.utils;

/**
 * Created by thanhle on 4/24/17.
 */

public class StringUtils {
    /**
     * Check string 's empty or no
     *
     * @param string
     * @return true if string's null or length = 0, false otherwise
     */
    public static boolean isEmptyString(String string) {
        return string == null || string.trim().equals("") || string.trim().length() <= 0;
    }
}
