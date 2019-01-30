package com.n2w.inpa.prototype.DestTripItineraryView;

import java.security.PublicKey;
import java.util.ArrayList;

public class DestTripItineraryModel {

    final public static int ITINERARY_HEADER = 0;
    final public static int ITINERARY_LISTS = 1;
    final public static int ITINERARY_TOTAL = 2;

    int type;

    String string1;
    String string2;
    String string3;
    String string4;

    public ArrayList<DestTripItineraryDateModel> mDayData;
    public ArrayList<DestTripItineraryListOfTripModel> mTPModelData;

    public DestTripItineraryModel(int type, String string1, String string2, String string3, String string4, ArrayList<DestTripItineraryDateModel> mDayData)
    {
        this.type = type;
        this.string1 = string1;
        this.string2 = string2;
        this.string3 = string3;
        this.string4 = string4;
        this.mDayData = mDayData;
    }

    public DestTripItineraryModel(int type, ArrayList<DestTripItineraryListOfTripModel> mTPModelData){

        this.mTPModelData = mTPModelData;
    }
}
