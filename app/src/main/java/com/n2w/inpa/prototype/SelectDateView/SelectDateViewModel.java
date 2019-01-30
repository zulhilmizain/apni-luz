package com.n2w.inpa.prototype.SelectDateView;

public class SelectDateViewModel {

    public static final int HEADER = 0;
    public static final int CALENDAR = 1;
    public static final int ADD_PARKS = 2;
    public static final int NEXT_STEP = 3;

    public int type;

    public SelectDateViewModel(int type)
    {
        this.type = type;
    }
}
