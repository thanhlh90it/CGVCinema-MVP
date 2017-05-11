package com.thanhlh.cinema.commom;

import android.app.Application;
import android.content.Context;

/**
 * Created by thanhle on 4/24/17.
 */

public class MyApplication extends Application {
    private static Context context;

    public synchronized static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
