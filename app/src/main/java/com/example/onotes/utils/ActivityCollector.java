package com.example.onotes.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cwj Apr.13.2017 5:58 PM
 * 活动管理。
 */

public class ActivityCollector {
    public static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity:activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
