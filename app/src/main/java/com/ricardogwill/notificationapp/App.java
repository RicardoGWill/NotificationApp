package com.ricardogwill.notificationapp;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

        @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    public static final String CHANNEL1_ID = "Channel 1";
    public static final String CHANNEL2_ID = "Channel 2";

    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel1 = new NotificationChannel(
                    CHANNEL1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel1.setDescription("This is Channel 1");

            NotificationChannel notificationChannel2 = new NotificationChannel(
                    CHANNEL2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            notificationChannel2.setDescription("This is Channel 2");

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel1);
            notificationManager.createNotificationChannel(notificationChannel2);
        }
    }


}
