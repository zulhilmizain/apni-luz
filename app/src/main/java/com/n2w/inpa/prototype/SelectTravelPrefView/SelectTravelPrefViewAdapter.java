package com.n2w.inpa.prototype.SelectTravelPrefView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.n2w.inpa.prototype.DestinationTripItinerary;
import com.n2w.inpa.prototype.R;
import com.n2w.inpa.prototype.SelectTravelPreference;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class SelectTravelPrefViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    ArrayList<SelectTravelPrefModel> mData;
    Activity mActivity;
    SelectTravelPreference mainClass;
    int viewChange = 0;

    public SelectTravelPrefViewAdapter(Context cont, Activity activity, ArrayList<SelectTravelPrefModel> mData, SelectTravelPreference mainClass)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
        this.mActivity = activity;
        this.mainClass = mainClass;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        if(viewChange == 0)
        {
            Log.d("PointChange","Holder: Pickup");
            switch (i)
            {
                case SelectTravelPrefModel.HEADER:
                    v = mInflater.inflate(R.layout.select_travel_preference_header, viewGroup, false);
                    return new SelectTravelPrefHeader(v);
                case SelectTravelPrefModel.TRAVEL_PREF:
                    v = mInflater.inflate(R.layout.select_travel_preference_selection, viewGroup, false);
                    return new SelectTravelPrefTravelPref(v);
                case SelectTravelPrefModel.PICKUP_POINT:
                    v = mInflater.inflate(R.layout.select_travel_preference_pickup_point, viewGroup, false);
                    return new SelectTravelPrefPickupPoint(v);
                case SelectTravelPrefModel.PICKUP_TIME:
                    v = mInflater.inflate(R.layout.select_travel_preference_pickup_time, viewGroup, false);
                    return new SelectTravelPrefPickupTime(v);
                case SelectTravelPrefModel.GENERATE_TRIP_BUTTON:
                    v = mInflater.inflate(R.layout.select_travel_preference_generatetrip, viewGroup, false);
                    return new SelectTravelPrefGenerateTrip(v);
            }
        }
        else
        {
            Log.d("PointChange","Holder: Meetup");
            switch (i)
            {
                case SelectTravelPrefModel.HEADER:
                    v = mInflater.inflate(R.layout.select_travel_preference_header, viewGroup, false);
                    return new SelectTravelPrefHeader(v);
                case SelectTravelPrefModel.TRAVEL_PREF:
                    v = mInflater.inflate(R.layout.select_travel_preference_selection, viewGroup, false);
                    return new SelectTravelPrefTravelPref(v);
                case SelectTravelPrefModel.MEETUP_POINT:
                    v = mInflater.inflate(R.layout.select_travel_preference_meetup_point, viewGroup, false);
                    return new SelectTravelPrefMeetupPoint(v);
                case SelectTravelPrefModel.MEETUP_TIME:
                    v = mInflater.inflate(R.layout.select_travel_preference_meetup_time, viewGroup, false);
                    return new SelectTravelPrefMeetupTime(v);
                case SelectTravelPrefModel.GENERATE_TRIP_BUTTON:
                    v = mInflater.inflate(R.layout.select_travel_preference_generatetrip, viewGroup, false);
                    return new SelectTravelPrefGenerateTrip(v);
            }
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        SelectTravelPrefModel data = mData.get(i);

        if(viewChange == 0)
        {
            Log.d("PointChange","Bind: Pickup");
            switch (i)
            {
                case SelectTravelPrefModel.TRAVEL_PREF:

                    int rd = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.getCheckedRadioButtonId();
                    View radPref = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.findViewById(rd);
                    int index = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.indexOfChild(radPref);

                    RadioButton radPrefBtn = (RadioButton)((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.getChildAt(index);

                    ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            View radioButton = group.findViewById(checkedId);
                            if(group.indexOfChild(radioButton) == 0)
                            {
                                viewChange = 0;
                                mainClass.ChangeToPickupPoint(false);
                            }
                            else
                            {
                                viewChange = 1;
                                mainClass.ChangeToMeetupPoint(false);
                            }
                            Log.d("Travel Preference","Selected: "+group.indexOfChild(radioButton));
                        }
                    });

                    break;

                case SelectTravelPrefModel.PICKUP_POINT:

                    ArrayList<SelectTravelPrefPredefLocationModel> mLocData = new ArrayList<>();

                    mLocData.add(new SelectTravelPrefPredefLocationModel("Lapangan Terbang Senai"));
                    mLocData.add(new SelectTravelPrefPredefLocationModel("Larkin Sentral"));
                    mLocData.add(new SelectTravelPrefPredefLocationModel("Melaka Sentral"));

                    LinearLayoutManager lM = new LinearLayoutManager(mActivity);
                    lM.setOrientation(LinearLayoutManager.HORIZONTAL);

                    ((SelectTravelPrefPickupPoint)viewHolder).rvTravelPrefPredefinedLocation.setAdapter(new SelectTravelPrefPredefLocationAdapter(mActivity,mLocData));
                    ((SelectTravelPrefPickupPoint)viewHolder).rvTravelPrefPredefinedLocation.setLayoutManager(lM);

                    ((SelectTravelPrefPickupPoint)viewHolder).btnTravelPrefGenerateTrip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("GenTrip","Pressed!");
                            mActivity.startActivity(new Intent(mActivity,DestinationTripItinerary.class));
                        }
                    });

                    break;
            }
        }
        else {

            Log.d("PointChange","Bind: Meetup");
            switch (i)
            {
                case SelectTravelPrefModel.TRAVEL_PREF:

                    int rd = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.getCheckedRadioButtonId();
                    View radPref = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.findViewById(rd);
                    int index = ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.indexOfChild(radPref);

                    RadioButton radPrefBtn = (RadioButton)((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.getChildAt(index);

                    ((SelectTravelPrefTravelPref) viewHolder).rgTravelPref.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            View radioButton = group.findViewById(checkedId);
                            if(group.indexOfChild(radioButton) == 0)
                            {
                                viewChange = mainClass.ChangeToPickupPoint(false);
                            }
                            else
                            {
                                viewChange = mainClass.ChangeToMeetupPoint(false);
                            }
                            Log.d("Travel Preference","Selected: "+group.indexOfChild(radioButton));
                        }
                    });

                    break;

                case SelectTravelPrefModel.MEETUP_POINT:


                    break;

                case SelectTravelPrefModel.GENERATE_TRIP_BUTTON:

                    Log.d("GenTrip","Calling");

                    ((SelectTravelPrefGenerateTrip)viewHolder).btnTravelPrefGenerateTrip.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.d("GenTrip","Pressed!");
                            mActivity.startActivity(new Intent(mActivity,DestinationTripItinerary.class));
                        }
                    });

                    break;
            }

        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {

        if(viewChange == 0)
        {
            Log.d("PointChange","Type: Pickup");
            switch (position)
            {
                case 0:
                    return SelectTravelPrefModel.HEADER;
                case 1:
                    return SelectTravelPrefModel.TRAVEL_PREF;
                case 2:
                    return SelectTravelPrefModel.PICKUP_POINT;
                case 3:
                    return SelectTravelPrefModel.PICKUP_TIME;
                case 4:
                    return SelectTravelPrefModel.GENERATE_TRIP_BUTTON;
                default:
                    return -1;
            }
        }
        else
        {
            Log.d("PointChange","Type: Meetup");
            switch (position)
            {
                case 0:
                    return SelectTravelPrefModel.HEADER;
                case 1:
                    return SelectTravelPrefModel.TRAVEL_PREF;
                case 2:
                    return SelectTravelPrefModel.MEETUP_POINT;
                case 3:
                    return SelectTravelPrefModel.MEETUP_TIME;
                case 4:
                    return SelectTravelPrefModel.GENERATE_TRIP_BUTTON;
                default:
                    return -1;
            }
        }

    }

    public class SelectTravelPrefHeader extends RecyclerView.ViewHolder{

        public SelectTravelPrefHeader(@NonNull View itemView) {
            super(itemView);

        }
    }

    public class SelectTravelPrefTravelPref extends RecyclerView.ViewHolder{

        RadioGroup rgTravelPref;
        RadioButton rbTravelPrefPickup;
        RadioButton rbTravelPrefMeetup;

        public SelectTravelPrefTravelPref(@NonNull View itemView) {
            super(itemView);

            rgTravelPref = itemView.findViewById(R.id.rgTravelPref);
            rbTravelPrefPickup = itemView.findViewById(R.id.rbTravelPrefPickup);
            rbTravelPrefMeetup = itemView.findViewById(R.id.rbTravelPrefMeetup);
        }
    }

    public class SelectTravelPrefPickupPoint extends RecyclerView.ViewHolder{

        EditText etTravelPrefAddress;
        RecyclerView rvTravelPrefPredefinedLocation;
        TimePicker tPTravelPrefPickupTime;
        Resources system;
        Button btnTravelPrefGenerateTrip;

        public SelectTravelPrefPickupPoint(@NonNull View itemView) {
            super(itemView);

            etTravelPrefAddress = itemView.findViewById(R.id.etTravelPrefAddress);
            rvTravelPrefPredefinedLocation = itemView.findViewById(R.id.rvTravelPrefPredefinedLocation);
            tPTravelPrefPickupTime = itemView.findViewById(R.id.tPTravelPrefPickupTime);
            btnTravelPrefGenerateTrip = itemView.findViewById(R.id.btnTravelPrefGenerateTrip);

            system = Resources.getSystem();
            int hour_numberpicker_id = system.getIdentifier("hour", "id", "android");
            int minute_numberpicker_id = system.getIdentifier("minute", "id", "android");
            int ampm_numberpicker_id = system.getIdentifier("amPm", "id", "android");

            NumberPicker hour_numberpicker = tPTravelPrefPickupTime.findViewById(hour_numberpicker_id);
            NumberPicker minute_numberpicker = tPTravelPrefPickupTime.findViewById(minute_numberpicker_id);
            NumberPicker ampm_numberpicker = tPTravelPrefPickupTime.findViewById(ampm_numberpicker_id);

            set_numberpicker_text_colour(hour_numberpicker);
            set_numberpicker_text_colour(minute_numberpicker);
            set_numberpicker_text_colour(ampm_numberpicker);

        }
    }

    public class SelectTravelPrefMeetupPoint extends RecyclerView.ViewHolder{

        TextView txtSelectTravelPrefMeetupLocation;

        public SelectTravelPrefMeetupPoint(@NonNull View itemView) {
            super(itemView);

            txtSelectTravelPrefMeetupLocation = itemView.findViewById(R.id.txtSelectTravelPrefMeetupLocation);
        }
    }

    public class SelectTravelPrefPickupTime extends RecyclerView.ViewHolder{

        TimePicker tPTravelPrefPickupTime;
        Resources system;

        public SelectTravelPrefPickupTime(@NonNull View itemView) {
            super(itemView);

            tPTravelPrefPickupTime = itemView.findViewById(R.id.tPTravelPrefPickupTime);

            system = Resources.getSystem();
            int hour_numberpicker_id = system.getIdentifier("hour", "id", "android");
            int minute_numberpicker_id = system.getIdentifier("minute", "id", "android");
            int ampm_numberpicker_id = system.getIdentifier("amPm", "id", "android");

            NumberPicker hour_numberpicker = tPTravelPrefPickupTime.findViewById(hour_numberpicker_id);
            NumberPicker minute_numberpicker = tPTravelPrefPickupTime.findViewById(minute_numberpicker_id);
            NumberPicker ampm_numberpicker = tPTravelPrefPickupTime.findViewById(ampm_numberpicker_id);

            set_numberpicker_text_colour(hour_numberpicker);
            set_numberpicker_text_colour(minute_numberpicker);
            set_numberpicker_text_colour(ampm_numberpicker);

        }
    }

    private void set_numberpicker_text_colour(NumberPicker number_picker){
        final int count = number_picker.getChildCount();
        final int color = mActivity.getResources().getColor(R.color.colorBlue);

        for(int i = 0; i < count; i++){
            View child = number_picker.getChildAt(i);

            try{
                Field wheelpaint_field = number_picker.getClass().getDeclaredField("mSelectorWheelPaint");
                wheelpaint_field.setAccessible(true);

                ((Paint)wheelpaint_field.get(number_picker)).setColor(color);
                ((EditText)child).setTextColor(color);
                ((EditText)child).setTextSize(24);
                number_picker.invalidate();
            }
            catch(NoSuchFieldException e){
                Log.w("setNumberPickerTextColo", e);
            }
            catch(IllegalAccessException e){
                Log.w("setNumberPickerTextColo", e);
            }
            catch(IllegalArgumentException e){
                Log.w("setNumberPickerTextColo", e);
            }
        }
    }

    public class SelectTravelPrefMeetupTime extends RecyclerView.ViewHolder{



        public SelectTravelPrefMeetupTime(@NonNull View itemView) {
            super(itemView);


        }
    }

    public class SelectTravelPrefGenerateTrip extends RecyclerView.ViewHolder{

        Button btnTravelPrefGenerateTrip;

        public SelectTravelPrefGenerateTrip(@NonNull View itemView) {
            super(itemView);

            btnTravelPrefGenerateTrip = itemView.findViewById(R.id.btnTravelPrefGenerateTrip);
        }
    }
}
