package com.ssoft.travel.ui;

import android.app.Application;

import com.ssoft.travel.BuildConfig;
import com.ssoft.travel.utils.LogHelper;

/**
 * Created by Administrator on 2017/8/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //判断是否打印日志
        if (BuildConfig.LOG_DEBUG == true) {
            LogHelper.init(true);
        } else {
            LogHelper.init(false);
        }
    }
}
