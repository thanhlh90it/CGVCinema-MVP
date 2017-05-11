package com.thanhlh.cinema.utils;

import android.util.Log;

/**
 * Created by thanhle on 4/24/17.
 */

public class LogObj {
    private String tag;
    private boolean showLog;

    public LogObj(String tag, boolean showLog) {
        this.tag = tag;
        this.showLog = showLog;
    }

    public void i(String msg) {
        if (showLog && LogUtils.debug) {
            Log.i(tag, msg != null ? msg : "Null");
        }
    }

    public void d(String msg) {
        if (showLog && LogUtils.debug) {
            Log.d(tag, msg != null ? msg : "Null");
        }
    }

    public void w(String msg) {
        if (showLog && LogUtils.debug) {
            Log.w(tag, msg != null ? msg : "Null");
        }
    }

    public void e(String msg) {
        if (showLog && LogUtils.debug) {
            Log.e(tag, msg != null ? msg : "Null");
        }
    }

    public void v(String msg) {
        if (showLog && LogUtils.debug) {
            LogUtils.v(tag, msg != null ? msg : "Null");
        }
    }
}
