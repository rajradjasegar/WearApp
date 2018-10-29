package com.example.vigneshrajradjasegar.wearapp.ui;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.wear.widget.WearableLinearLayoutManager;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

import com.example.vigneshrajradjasegar.wearapp.R;
import com.example.vigneshrajradjasegar.wearapp.helpers.CustomRecyclerAdapter;
import com.example.vigneshrajradjasegar.wearapp.helpers.CustomScrollingLayoutCallback;

import android.support.wear.widget.WearableRecyclerView;

public class MainActivity extends WearableActivity {

    private WearableRecyclerView mWearableRecyclerView;
    private CustomRecyclerAdapter mCustomRecyclerAdapter;
    private TextView mTextView;
    String []  DATA_LIST = {"JUST CLICK", "Create a Notification", "Msg Mobile", "Req API", "Custom Face"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);
        mWearableRecyclerView = (WearableRecyclerView) findViewById(R.id.recycler_launcher_view);

        // Enables Always-on
        setAmbientEnabled();

        // To align the edge children (first and last) with the center of the screen
        mWearableRecyclerView.setEdgeItemsCenteringEnabled(true);
        /*mWearableRecyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this));*/
        // TODO DECOMMENT THIS IF YOU WANT TO
        CustomScrollingLayoutCallback customScrollingLayoutCallback =
                new CustomScrollingLayoutCallback();
        mWearableRecyclerView.setLayoutManager(
                new WearableLinearLayoutManager(this, customScrollingLayoutCallback));

        // TODO CES 3 LIGNES POSENT PROBLEMES LORS DU SCROLLING A REVERIFIER LEUR UTILITE
       /* mWearableRecyclerView.setCircularScrollingGestureEnabled(true);
        mWearableRecyclerView.setBezelFraction(0.5f);
        mWearableRecyclerView.setScrollDegreesPerScreen(90);*/

       // Improves performance because we know changes in content do not change the layout size of
        // the RecyclerView.
        mWearableRecyclerView.setHasFixedSize(true);
        // Specifies an adapter (see also next example).
        mCustomRecyclerAdapter = new CustomRecyclerAdapter(
                DATA_LIST, this);

        mWearableRecyclerView.setAdapter(mCustomRecyclerAdapter);

    }

    //public void onClick (View view ){
    public void onClick (int position ){
        Log.d("log wear", "we clicked on position " + position);
        String value = DATA_LIST[position];
        switch(value) {
            case "JUST CLICK":
                startAnotherActivity();
                break;
            case "Create a Notification":
                createSimpleNotification();
                break;
        }
    }


    public void startAnotherActivity (){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void createSimpleNotification(){
        int notificationId = 001;
        // The channel ID of the notification.
        String id = "notification_channel_01";
        // Build intent for notification content
        Intent viewIntent = new Intent(this, NotificationActivity.class);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        // Notification channel ID is ignored for Android 7.1.1
        // (API level 25) and lower.
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, id)
                        .setSmallIcon(R.drawable.round_notification_important_black_24dp)
                        .setContentTitle("Simple Notif")
                        .setContentText("This is notification content")
                        .setContentIntent(viewPendingIntent);

        // Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        // Issue the notification with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
