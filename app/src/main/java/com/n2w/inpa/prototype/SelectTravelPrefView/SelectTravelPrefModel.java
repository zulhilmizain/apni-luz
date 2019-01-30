package com.n2w.inpa.prototype.SelectTravelPrefView;

public class SelectTravelPrefModel {

    final static public int HEADER = 0;
    final static public int TRAVEL_PREF = 1;
    final static public int PICKUP_POINT = 2;
    final static public int PICKUP_TIME = 3;
    final static public int MEETUP_POINT = 4;
    final static public int MEETUP_TIME = 5;
    final static public int GENERATE_TRIP_BUTTON = 6;

    private int type;

    public SelectTravelPrefModel(int type)
    {
        this.type = type;
    }


}
