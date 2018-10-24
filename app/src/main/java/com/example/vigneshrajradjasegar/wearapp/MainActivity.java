package com.example.vigneshrajradjasegar.wearapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.vigneshrajradjasegar.wearapp.SecondActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void onClick (View view ){
        Log.d("log wear", "JUST CLICKED !");

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        //finish(); // REMOVE THIS IF YOU WANT to finish activity when it will go to other activity
    }
}
