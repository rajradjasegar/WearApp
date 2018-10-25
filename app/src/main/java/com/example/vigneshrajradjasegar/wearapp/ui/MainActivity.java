package com.example.vigneshrajradjasegar.wearapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.wear.widget.WearableLinearLayoutManager;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

        mWearableRecyclerView.setCircularScrollingGestureEnabled(true);
        mWearableRecyclerView.setBezelFraction(0.5f);
        mWearableRecyclerView.setScrollDegreesPerScreen(90);
        // Specifies an adapter (see also next example).
        mCustomRecyclerAdapter = new CustomRecyclerAdapter(
                DATA_LIST, this);

        mWearableRecyclerView.setAdapter(mCustomRecyclerAdapter);

    }

    //public void onClick (View view ){
    public void onClick (int position ){
        Log.d("log wear", "we clicked on position " + position);

        if(DATA_LIST[position].equals("JUST CLICK")) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
        //finish(); // REMOVE THIS IF YOU WANT to finish activity when it will go to other activity
    }
}
