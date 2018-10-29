package com.example.vigneshrajradjasegar.wearapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.wearable.activity.ConfirmationActivity;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;

import com.example.vigneshrajradjasegar.wearapp.R;

public class SecondActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Enables Always-on
        setAmbientEnabled();
    }

    public void onClick (View view ){
        Log.d("log wear", "SUCCESS CLICKED !");
        Intent intent = new Intent(this, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                ConfirmationActivity.SUCCESS_ANIMATION);
        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE, "SUCCESS !");
        startActivity(intent);
        //finish();
    }
}
