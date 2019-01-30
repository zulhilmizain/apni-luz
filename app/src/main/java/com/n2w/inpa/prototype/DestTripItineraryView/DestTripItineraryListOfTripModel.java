package com.n2w.inpa.prototype.DestTripItineraryView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

public class DestTripItineraryListOfTripModel {

    final static public int TRIP_START = 0;
    final static public int TRIP_VEHICLE_SELECT = 1;
    final static public int TRIP_ACTIVITIES = 2;

    final static public int LOT_PICKUP_TIME = 100;
    public String pickupTime;
    final static public int LOT_PICKUP_PLACE = 101;
    public String pickupPlace;

    final static public int LOT_VEHICLE_TYPE = 110;
    public String vehicleSelected;
    final static public int LOT_VEHICLE_PRICE = 111;
    public String vehiclePrice;

    final static public int LOT_ACTIVITY_TIME = 120;
    public String activityTime;
    final static public int LOT_ACTIVITY_PRICE = 121;
    public String activityPrice;
    final static public int LOT_ACTIVITY_NAME = 122;
    public String activityName;

    public DestTripItineraryListOfTripModel(int type, Map<Integer,String> data)
    {
        switch (type)
        {
            case TRIP_START:

                this.pickupTime = data.get(LOT_PICKUP_TIME);
                this.pickupPlace = data.get(LOT_PICKUP_PLACE);

                break;

            case TRIP_VEHICLE_SELECT:

                this.vehicleSelected = data.get(LOT_VEHICLE_TYPE);
                this.vehiclePrice = data.get(LOT_VEHICLE_PRICE);

                break;

            case TRIP_ACTIVITIES:

                this.activityTime = data.get(LOT_ACTIVITY_TIME);
                this.activityPrice = data.get(LOT_ACTIVITY_PRICE);
                this.activityName = data.get(LOT_ACTIVITY_NAME);
        }
    }

}
