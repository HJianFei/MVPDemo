package com.apaces.demo.base;

import android.app.Activity;
import android.app.Application;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HJianFei on 2017/6/29.
 * <p>
 * 描述：
 */

public class App extends Application {

    private static App instance;
    private Set<Activity> allActivities;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

    }

    public static synchronized App getInstance() {
        return instance;
    }

    /**
     * 添加activity
     */
    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    /**
     * 移除activity
     */
    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    /**
     * 退出app
     */
    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
