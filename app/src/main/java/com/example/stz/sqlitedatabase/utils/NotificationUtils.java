package com.example.stz.sqlitedatabase.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.example.stz.sqlitedatabase.MainActivity;
import com.example.stz.sqlitedatabase.R;


/**
 * Created by pyaesone on 9/26/18
 */
public class NotificationUtils {

    private static final int NOTIFICATION_ID = 4200;


    public static void showNotification(String notificationText, Context context) {
        int notifyID = 1;
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
      // The user-visible name of the channel.
        int importance = NotificationManager.IMPORTANCE_HIGH;

        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "no", importance);
        Context mcontext = context;

        //Notification Title
        String title = mcontext.getString(R.string.app_name);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mcontext,CHANNEL_ID)
                .setColor(mcontext.getResources().getColor(R.color.colorAccent))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(notificationText)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText))
                .setAutoCancel(true)
                .setChannelId(CHANNEL_ID);


        //Open the app when user tap on notification
        Intent resultIntent = new Intent(mcontext, MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(mcontext);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);

        NotificationManager notificationManager = (NotificationManager) mcontext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(mChannel);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

}
