package com.n2w.inpa.prototype.DestTripItineraryView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class DestTripItineraryListOfTripAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    ArrayList<DestTripItineraryListOfTripModel> mData;

    public DestTripItineraryListOfTripAdapter(Context cont, ArrayList<DestTripItineraryListOfTripModel> mData)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        switch (i)
        {
            case DestTripItineraryListOfTripModel.TRIP_START:
                v = mInflater.inflate(R.layout.trip_itinerary_listoftrip_header, viewGroup, false);
                return new DestTripItineraryLOTHeader(v);
            case DestTripItineraryListOfTripModel.TRIP_VEHICLE_SELECT:
                v = mInflater.inflate(R.layout.trip_itinerary_listoftrip_vehicle, viewGroup, false);
                return new DestTripItineraryLOTVehicle(v);
            default:
                v = mInflater.inflate(R.layout.trip_itinerary_listoftrip_activities, viewGroup, false);
                return new DestTripItineraryLOTActivities(v);

        }
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);

        switch (position)
        {
            case 0:
                return DestTripItineraryListOfTripModel.TRIP_START;
            case 1:
                return DestTripItineraryListOfTripModel.TRIP_VEHICLE_SELECT;
            default:
                return DestTripItineraryListOfTripModel.TRIP_ACTIVITIES;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        DestTripItineraryListOfTripModel data = mData.get(i);

        switch (i)
        {
            case DestTripItineraryListOfTripModel.TRIP_START:

                ((DestTripItineraryLOTHeader) viewHolder).tvTripListHeaderPlaceName.setText(data.pickupPlace);
                ((DestTripItineraryLOTHeader) viewHolder).tvTripListHeaderTime.setText(data.pickupTime);

                break;
            case DestTripItineraryListOfTripModel.TRIP_VEHICLE_SELECT:

                ((DestTripItineraryLOTVehicle) viewHolder).tvTripListVehicleTravels.setText(data.vehicleSelected);
                ((DestTripItineraryLOTVehicle) viewHolder).tvTripListVehiclePrice.setText(data.vehiclePrice);

                break;

            case DestTripItineraryListOfTripModel.TRIP_ACTIVITIES:

                ((DestTripItineraryLOTActivities) viewHolder).tvTripListActivityTime.setText(data.activityTime);
                ((DestTripItineraryLOTActivities) viewHolder).tvTripListActivityPrice.setText(data.activityPrice);
                ((DestTripItineraryLOTActivities) viewHolder).tvTripListActivityName.setText(data.activityName);

                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class DestTripItineraryLOTHeader extends RecyclerView.ViewHolder
    {
        TextView tvTripListHeaderTime;
        TextView tvTripListHeaderPlaceName;

        public DestTripItineraryLOTHeader(@NonNull View itemView) {
            super(itemView);

            tvTripListHeaderTime = itemView.findViewById(R.id.tvTripListHeaderTime);
            tvTripListHeaderPlaceName = itemView.findViewById(R.id.tvTripListHeaderPlaceName);
        }
    }

    public class DestTripItineraryLOTVehicle extends RecyclerView.ViewHolder
    {
        TextView tvTripListVehicleTravels;
        TextView tvTripListVehiclePrice;

        public DestTripItineraryLOTVehicle(@NonNull View itemView) {
            super(itemView);

            tvTripListVehicleTravels = itemView.findViewById(R.id.tvTripListVehicleTravels);
            tvTripListVehiclePrice = itemView.findViewById(R.id.tvTripListVehiclePrice);
        }
    }

    public class DestTripItineraryLOTActivities extends RecyclerView.ViewHolder
    {
        TextView tvTripListActivityTime;
        TextView tvTripListActivityPrice;
        TextView tvTripListActivityName;

        public DestTripItineraryLOTActivities(@NonNull View itemView) {
            super(itemView);

            tvTripListActivityTime = itemView.findViewById(R.id.tvTripListActivityTime);
            tvTripListActivityPrice = itemView.findViewById(R.id.tvTripListActivityPrice);
            tvTripListActivityName = itemView.findViewById(R.id.tvTripListActivityName);
        }
    }
}
