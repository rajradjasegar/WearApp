package com.example.vigneshrajradjasegar.wearapp.helpers;

import android.support.wear.widget.WearableRecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vigneshrajradjasegar.wearapp.R;
import com.example.vigneshrajradjasegar.wearapp.ui.MainActivity;

/**
 * Created by VigneshrajRADJASEGAR on 24/10/2018.
 */

public class CustomRecyclerAdapter extends WearableRecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    String [] mDataSet;
    MainActivity mMaintActivity;
    public static class ViewHolder extends WearableRecyclerView.ViewHolder {

        private final TextView mTextView;


        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.recycler_textView);
        }

        @Override
        public String toString() { return (String) mTextView.getText(); }
    }

    public CustomRecyclerAdapter(String[] dataSet, MainActivity mainActivity) {
        mDataSet = dataSet;
        mMaintActivity = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d("Adapter log", "Element " + position + " set.");

        viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mMaintActivity.onClick(position);
            }
        });

        // Replaces content of view with correct element from data set
        viewHolder.mTextView.setText(mDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
