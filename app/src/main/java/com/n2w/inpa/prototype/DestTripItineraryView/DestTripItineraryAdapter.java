package com.n2w.inpa.prototype.DestTripItineraryView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.n2w.inpa.prototype.PaymentSummary;
import com.n2w.inpa.prototype.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class DestTripItineraryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    ArrayList<DestTripItineraryModel> mData;
    Context mCont;
    Activity mActivity;

    public DestTripItineraryAdapter(Context cont, Activity activity, ArrayList<DestTripItineraryModel> mData)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
        this.mCont = cont;
        this.mActivity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        switch (i)
        {
            case DestTripItineraryModel.ITINERARY_HEADER:

                v = mInflater.inflate(R.layout.trip_itinerary_dest_header, viewGroup, false);
                return new DestTripItineraryHeader(v);

            case DestTripItineraryModel.ITINERARY_LISTS:

                v = mInflater.inflate(R.layout.trip_itinerary_listoftrip, viewGroup, false);
                return new DestTripItineraryListOfActivity(v);

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        DestTripItineraryModel data = mData.get(i);

        switch (i)
        {
            case DestTripItineraryModel.ITINERARY_HEADER:

                //((DestTripItineraryHeader)viewHolder).ivTripItineraryDestHeaderBackImg.setImageURI(Uri.parse(data.string1));
                //((DestTripItineraryHeader)viewHolder).tvTripItineraryDestHeaderPlace.setText(data.string2);
                //((DestTripItineraryHeader)viewHolder).tvTripItineraryDestHeaderDate.setText(data.string3);
                //((DestTripItineraryHeader)viewHolder).tvTripItineraryDestHeaderSum.setText(data.string4);

                LinearLayoutManager lM = new LinearLayoutManager(mCont);
                lM.setOrientation(LinearLayoutManager.HORIZONTAL);

                ((DestTripItineraryHeader) viewHolder).rvTripItineraryDestHeaderDates.setAdapter(new DestTripItineraryDateAdapter(mCont,data.mDayData));
                ((DestTripItineraryHeader) viewHolder).rvTripItineraryDestHeaderDates.setLayoutManager(lM);

                break;

            case DestTripItineraryModel.ITINERARY_LISTS:

                ((DestTripItineraryListOfActivity)viewHolder).rvTripItineraryListofTrip.setAdapter(new DestTripItineraryListOfTripAdapter(mCont, data.mTPModelData));
                ((DestTripItineraryListOfActivity)viewHolder).rvTripItineraryListofTrip.setLayoutManager(new LinearLayoutManager(mCont));

                ((DestTripItineraryListOfActivity)viewHolder).btnTripItineraryPay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent payment = new Intent(mActivity, PaymentSummary.class);
                        mActivity.startActivity(payment);
                    }
                });

                break;


        }

    }

    @Override
    public int getItemViewType(int position) {

        switch (position)
        {
            case 0:
                return DestTripItineraryModel.ITINERARY_HEADER;
            case 1:
                return DestTripItineraryModel.ITINERARY_LISTS;
            case 2:
                return DestTripItineraryModel.ITINERARY_TOTAL;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DestTripItineraryHeader extends RecyclerView.ViewHolder
    {
        ImageView ivTripItineraryDestHeaderBackImg;
        TextView tvTripItineraryDestHeaderPlace;
        TextView tvTripItineraryDestHeaderDate;
        TextView tvTripItineraryDestHeaderSum;
        RecyclerView rvTripItineraryDestHeaderDates;

        public DestTripItineraryHeader(@NonNull View itemView) {
            super(itemView);

            ivTripItineraryDestHeaderBackImg = itemView.findViewById(R.id.ivTripItineraryDestHeaderBackImg);
            tvTripItineraryDestHeaderPlace = itemView.findViewById(R.id.tvTripItineraryDestHeaderPlace);
            tvTripItineraryDestHeaderDate = itemView.findViewById(R.id.tvTripItineraryDestHeaderDate);
            tvTripItineraryDestHeaderSum = itemView.findViewById(R.id.tvTripItineraryDestHeaderSum);
            rvTripItineraryDestHeaderDates = itemView.findViewById(R.id.rvTripItineraryDestHeaderDates);
        }
    }

    public class DestTripItineraryListOfActivity extends RecyclerView.ViewHolder
    {
        RecyclerView rvTripItineraryListofTrip;
        Button btnTripItineraryPay;

        public DestTripItineraryListOfActivity(@NonNull View itemView) {
            super(itemView);

            rvTripItineraryListofTrip = itemView.findViewById(R.id.rvTripItineraryListofTrip);
            btnTripItineraryPay = itemView.findViewById(R.id.btnTripItineraryPay);
        }
    }

    public class DestTripItineraryTotal extends RecyclerView.ViewHolder
    {

        public DestTripItineraryTotal(@NonNull View itemView) {
            super(itemView);
        }
    }

}
