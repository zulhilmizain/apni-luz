package com.n2w.inpa.prototype.DestTripItineraryView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DestTripItineraryDateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    ArrayList<DestTripItineraryDateModel> mData;

    public DestTripItineraryDateAdapter(Context cont, ArrayList<DestTripItineraryDateModel> data)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        v = mInflater.inflate(R.layout.trip_itinerary_dest_listdate_date, viewGroup,false);

        return new DestTripItineraryDateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        DestTripItineraryDateModel data = mData.get(i);

        ((DestTripItineraryDateViewHolder)viewHolder).tvTripItineraryDestListDateDay.setText(data.dateDayStr);
        ((DestTripItineraryDateViewHolder)viewHolder).tvTripItineraryDestListDateDate.setText(data.dateDayNum);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DestTripItineraryDateViewHolder extends RecyclerView.ViewHolder {

        TextView tvTripItineraryDestListDateDay;
        TextView tvTripItineraryDestListDateDate;

        public DestTripItineraryDateViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTripItineraryDestListDateDay = itemView.findViewById(R.id.tvTripItineraryDestListDateDay);
            tvTripItineraryDestListDateDate = itemView.findViewById(R.id.tvTripItineraryDestListDateDate);
        }
    }
}
