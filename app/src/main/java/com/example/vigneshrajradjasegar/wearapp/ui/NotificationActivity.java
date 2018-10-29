package com.example.vigneshrajradjasegar.wearapp.ui;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.example.vigneshrajradjasegar.wearapp.R;

public class NotificationActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mTextView = (TextView) findViewById(R.id.text_notif);

        // Enables Always-on
        setAmbientEnabled();
    }
}
