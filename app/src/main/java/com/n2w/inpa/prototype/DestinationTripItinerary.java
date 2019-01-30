package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.n2w.inpa.prototype.DestTripItineraryView.DestTripItineraryAdapter;
import com.n2w.inpa.prototype.DestTripItineraryView.DestTripItineraryDateModel;
import com.n2w.inpa.prototype.DestTripItineraryView.DestTripItineraryListOfTripModel;
import com.n2w.inpa.prototype.DestTripItineraryView.DestTripItineraryModel;
import com.n2w.inpa.prototype.DestinationViewDetails.DestinationModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationTripItinerary extends AppCompatActivity {

    RecyclerView rvTripItinerary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_trip_itinerary);

        rvTripItinerary = findViewById(R.id.rvTripItinerary);

        ArrayList<DestTripItineraryDateModel> mDateData = new ArrayList<>();

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat afterDateFormatNum = new SimpleDateFormat("dd");
            SimpleDateFormat afterDateFormatStr = new SimpleDateFormat("EEE");
            Calendar dateFrom = Calendar.getInstance();
            Calendar dateUntil = Calendar.getInstance();

            dateFrom.setTime(dateFormat.parse("22.10.2018"));
            dateUntil.setTime(dateFormat.parse("27.10.2018"));

            while (dateFrom.compareTo(dateUntil) != 0)
            {
                //Log.d("DateModel","Parsed: "+afterDateFormat.format(dateFrom.getTime()));
                mDateData.add(new DestTripItineraryDateModel(afterDateFormatStr.format(dateFrom.getTime()), afterDateFormatNum.format(dateFrom.getTime())));
                dateFrom.add(Calendar.DATE, 1);
            }

            mDateData.add(new DestTripItineraryDateModel(afterDateFormatStr.format(dateUntil.getTime()), afterDateFormatNum.format(dateUntil.getTime())));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        for(DestTripItineraryDateModel data : mDateData)
        {
            Log.d("DateModel","Parsed Number: "+data.dateDayNum);
            Log.d("DateModel","Parsed Month: "+data.dateDayStr);
        }


        ArrayList<DestTripItineraryModel> mData = new ArrayList<>();
        mData.add(new DestTripItineraryModel(DestTripItineraryModel.ITINERARY_HEADER,"","","", "",mDateData));

        ArrayList<DestTripItineraryListOfTripModel> mTpData = new ArrayList<>();
        Map<Integer, String> mDData = new HashMap<>();

        mDData.put(DestTripItineraryListOfTripModel.LOT_PICKUP_TIME, "1000-1100");
        mDData.put(DestTripItineraryListOfTripModel.LOT_PICKUP_PLACE, "Pickup at SSAS");
        mTpData.add(new DestTripItineraryListOfTripModel(DestTripItineraryListOfTripModel.TRIP_START, mDData));

        mDData.clear();
        mDData.put(DestTripItineraryListOfTripModel.LOT_VEHICLE_TYPE, "Travelling with Taxi");
        mDData.put(DestTripItineraryListOfTripModel.LOT_VEHICLE_PRICE, "RM 200");
        mTpData.add(new DestTripItineraryListOfTripModel(DestTripItineraryListOfTripModel.TRIP_VEHICLE_SELECT, mDData));

        mDData.clear();
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_TIME, "1100 - 1200");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_PRICE, "RM 300");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_NAME, "Have a breakfast at Mak Poon");
        mTpData.add(new DestTripItineraryListOfTripModel(DestTripItineraryListOfTripModel.TRIP_ACTIVITIES, mDData));

        mDData.clear();
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_TIME, "1100 - 1200");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_PRICE, "RM 300");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_NAME, "Check in at Selai");
        mTpData.add(new DestTripItineraryListOfTripModel(DestTripItineraryListOfTripModel.TRIP_ACTIVITIES, mDData));

        mDData.clear();
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_TIME, "1100 - 1200");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_PRICE, "RM 300");
        mDData.put(DestTripItineraryListOfTripModel.LOT_ACTIVITY_NAME, "Water Tubing");
        mTpData.add(new DestTripItineraryListOfTripModel(DestTripItineraryListOfTripModel.TRIP_ACTIVITIES, mDData));

        mData.add(new DestTripItineraryModel(DestTripItineraryModel.ITINERARY_LISTS, mTpData));



        rvTripItinerary.setAdapter(new DestTripItineraryAdapter(this,this, mData));
        rvTripItinerary.setLayoutManager(new LinearLayoutManager(this));
    }
}
