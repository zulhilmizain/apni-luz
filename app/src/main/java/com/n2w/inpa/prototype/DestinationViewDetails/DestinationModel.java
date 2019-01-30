package com.n2w.inpa.prototype.DestinationViewDetails;


import com.n2w.inpa.prototype.CardPagerAdapter;

import java.util.ArrayList;

public class DestinationModel {

    public static final int HEADER = 0;
    public static final int DESCRIPTION = 1;
    public static final int LINE = 2;
    public static final int FEATURES = 3;
    public static final int POI_VIEWCARD = 4;
    public static final int POINT_DESCRIPTION = 5;
    public static final int RULES = 6;
    public static final int LOCATION = 7;
    public static final int REVIEWS = 8;
    public static final int NOTES = 9;
    public static final int BOOKBUTTON = 10;

    public int type;
    public String desc;
    public String imageURLString;
    public ArrayList<FeaturesModel> mFeatModel;
    public ArrayList<IconCellsModel> mIconCellsModel;
    public ArrayList<IconIICellsModel> mIconIICellsModel;
    public CardPagerAdapter cardPagerAdapter;
    public boolean useBullets;
    public double lat;
    public double lon;

    public DestinationModel(int type)
    {
        this.type = type;
    }

    public DestinationModel(int type, String stringDescription)
    {
        this.type = type;
        this.desc = stringDescription;
    }

    public DestinationModel(int type, String titleDescription, String imageURLString)
    {
        this.type = type;
        this.desc = titleDescription;
        this.imageURLString = imageURLString;
    }

    public DestinationModel(int type, ArrayList<FeaturesModel> mFeatModel)
    {
        this.type = type;
        this.mFeatModel = mFeatModel;
    }

    public DestinationModel(int type, CardPagerAdapter cardPagerAdapter)
    {
        this.type = type;
        this.cardPagerAdapter = cardPagerAdapter;
    }

    public DestinationModel(int type, ArrayList<IconCellsModel> mIconCellsModel, boolean useBullets)
    {
        this.type = type;
        this.mIconCellsModel = mIconCellsModel;
        this.useBullets = useBullets;
    }

    public DestinationModel(ArrayList<IconIICellsModel> mIconIICellsModel, int type)
    {
        this.mIconIICellsModel = mIconIICellsModel;
        this.type = type;
    }

    public DestinationModel(int type, double lat, double lon)
    {
        this.type = type;
        this.lat = lat;
        this.lon = lon;
    }


}
