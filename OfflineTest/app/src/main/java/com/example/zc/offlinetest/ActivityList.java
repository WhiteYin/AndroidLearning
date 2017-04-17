package com.example.zc.offlinetest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 作者：Zhou Cong on 2017/4/17 11:02
 * 邮箱：739094973@qq.com
 */

public class ActivityList {
    public static List<Activity> activityList=new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void removeAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing())
                activity.finish();
        }
    }
}
