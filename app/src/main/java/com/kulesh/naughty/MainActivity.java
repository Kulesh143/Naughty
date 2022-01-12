package com.kulesh.naughty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("C1","channel 1", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager managerr = getSystemService(NotificationManager.class);
            managerr.createNotificationChannel(channel);
        }
    }


    public void call(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "C1");
        builder.setSmallIcon(R.drawable.img);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            builder.setColor(getColor(R.color.black));
        }
        builder.setContentTitle("My Name is Kulesh Uchiha");
        builder.setContentText("You are now seeing a notification");
        builder.setSubText("Kulesh");

        Intent intent = new Intent(getApplicationContext(), MainActivity4.class);



                    intent.putExtra("kkl","Kulesh");
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 100, intent, 0);
        builder.setContentIntent(pendingIntent);

        Notification notification = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
        managerCompat.notify(new Random().nextInt(), notification);
    }
}