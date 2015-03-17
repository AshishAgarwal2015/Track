package com.example.track;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

import java.io.FileOutputStream;
import java.util.HashMap;

public class NotificationService extends NotificationListenerService
{

    public static HashMap<String, HashMap<String,Integer>> hashMap = new HashMap<String,HashMap<String,Integer>>();

    Context context;
    
    private void writeToDatabase(StatusBarNotification statusbarnotification)
    {
        String pack = statusbarnotification.getPackageName();
        String text = statusbarnotification.getNotification().extras.getString("android.title");
        HashMap hashmap = (HashMap)hashMap.get(pack);
        if (hashmap != null)
        {
            if (hashmap.get(text) != null)
            {  int count = (Integer) hashmap.get(text);
                hashmap.put(text, ++count);
            } 
            else
            {
                hashmap.put(text, 1 );
            }
        } 
        else
        {
            HashMap hashmap1 = new HashMap();
            hashmap1.put(text, 1);
            hashMap.put(pack, hashmap1);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        context = getApplicationContext();
    }

    public void onNotificationPosted(StatusBarNotification statusbarnotification)
    {
        writeToDatabase(statusbarnotification);
    }

}
