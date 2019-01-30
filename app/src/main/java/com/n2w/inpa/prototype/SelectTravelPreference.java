package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.n2w.inpa.prototype.SelectTravelPrefView.SelectTravelPrefModel;
import com.n2w.inpa.prototype.SelectTravelPrefView.SelectTravelPrefViewAdapter;

import java.util.ArrayList;

public class SelectTravelPreference extends AppCompatActivity {

    RecyclerView rvTravelPreference;
    ArrayList<SelectTravelPrefModel> mData;
    SelectTravelPrefViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_travel_preference);

        rvTravelPreference = findViewById(R.id.rvTravelPreference);

        mData = new ArrayList<>();
        mAdapter = new SelectTravelPrefViewAdapter(this, this, mData, this);

        ChangeToPickupPoint(true);
        rvTravelPreference.setAdapter(mAdapter);
        rvTravelPreference.setLayoutManager(new LinearLayoutManager(this));
    }

    public int ChangeToPickupPoint(boolean firstTimeRun)
    {
        Log.d("PointChange","Pickup");
        if (!firstTimeRun) mData.clear();
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.HEADER));
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.TRAVEL_PREF));
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.PICKUP_POINT));

        if (!firstTimeRun) {
            mAdapter.notifyDataSetChanged();
            //rvTravelPreference.invalidate();
        }

        return 0;
    }

    public int ChangeToMeetupPoint(boolean firstTimeRun)
    {
        Log.d("PointChange","Meetup");
        if (!firstTimeRun) mData.clear();
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.HEADER));
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.TRAVEL_PREF));
        mData.add(new SelectTravelPrefModel(SelectTravelPrefModel.MEETUP_POINT));

        if (!firstTimeRun){
            mAdapter.notifyDataSetChanged();
            //rvTravelPreference.invalidate();
        }

        return 1;
    }
}
