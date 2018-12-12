package com.example.stz.sqlitedatabase;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stz.sqlitedatabase.utils.NotificationUtils;

public class MainActivity extends Activity {
   // DatabaseHelper myDB;
    Button buttonNotification;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //   myDB = new DatabaseHelper(this);


       buttonNotification=(Button)findViewById(R.id.btn_notification);
       buttonNotification.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
  NotificationUtils.showNotification("Notification",getApplicationContext());
               Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_LONG).show();
           }
       });

    }




}

