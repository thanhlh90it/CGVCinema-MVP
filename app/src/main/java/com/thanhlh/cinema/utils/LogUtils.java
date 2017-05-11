package com.thanhlh.cinema.utils;

import android.util.Log;

import com.thanhlh.cinema.commom.Constants;

/**
 * Created by thanhle on 4/24/17.
 */

public class LogUtils {
    public static final String TAG = "DEMO_DEV";
    protected static boolean debug = Constants.DEBUG_MODE;

    public static LogObj HTTP = new LogObj("HTTP >>>", debug);
    public static LogObj RX_ANDROID = new LogObj("RX_ANDROID >>>", debug);

    private static String getTag(Object clazz) {
        String tag = TAG;
        if (null != clazz) {
            tag = clazz.getClass().getCanonicalName();
        }
        return tag;
    }

    public static void i(Object clazz, String msg) {
        if (debug) {
            Log.i(getTag(clazz), msg != null ? msg : "Null");
        }
    }

    public static void d(Object clazz, String msg) {
        if (debug) {
            Log.d(getTag(clazz), msg != null ? msg : "Null");
        }
    }

    public static void w(Object clazz, String msg) {
        if (debug) {
            Log.w(getTag(clazz), msg != null ? msg : "Null");
        }
    }

    public static void e(Object clazz, String msg) {
        if (null == msg) {
            return;
        }

        Log.e(getTag(clazz), msg);
    }

    public static void v(Object clazz, String msg) {
        if (debug) {
            Log.v(getTag(clazz), msg != null ? msg : "Null");
        }
    }

    public static boolean isShowLog() {
        return debug;
    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg != null ? msg : "Null");
        }
    }

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg != null ? msg : "Null");
        }
    }

    public static void w(String tag, String msg) {
        if (debug) {
            Log.w(tag, msg != null ? msg : "Null");
        }
    }

    public static void e(String tag, String msg) {
        if (null == msg) {
            return;
        }

        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Exception e) {
        if (null == msg) {
            return;
        }

        Log.e(tag, msg + (null == e ? "" : ", " + e.toString()));
    }

    public static void e(String tag, String msg, Error e) {
        if (null == msg) {
            return;
        }

        Log.e(tag, msg + (null == e ? "": ", " + e.toString()));
    }

    public static void e(String tag, Exception e) {
        if (null == e) {
            return;
        }

        Log.e(tag, e.toString());
    }
}
