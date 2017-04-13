package com.example.zc.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：活动容器，用于退出添加所有活动
 * 作者：Zhou Cong on 2017/4/13 12:58
 * 邮箱：739094973@qq.com
 */

public class ActivityCollector {
    public static List<Activity> activityList=new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void removeAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
