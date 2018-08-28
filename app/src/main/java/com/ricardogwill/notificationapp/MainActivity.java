package com.ricardogwill.notificationapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.ricardogwill.notificationapp.App.CHANNEL1_ID;
import static com.ricardogwill.notificationapp.App.CHANNEL2_ID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationTitleEditText = findViewById(R.id.notification_title_editText);
        notificationMessageEditText = findViewById(R.id.notification_message_editText);
    }

    private NotificationManagerCompat notificationManagerCompat;
    private EditText notificationTitleEditText;
    private EditText notificationMessageEditText;

    public void sendOnChannelOneButtonOnClick(View view) {
        String title = notificationTitleEditText.getText().toString();
        String message = notificationMessageEditText.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendOnChannelTwoButtonOnClick(View view) {
        String title = notificationTitleEditText.getText().toString();
        String message = notificationMessageEditText.getText().toString();

        Notification notification = new NotificationCompat.Builder(this, CHANNEL2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManagerCompat.notify(2, notification);
    }

}
