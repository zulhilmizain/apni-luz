package com.n2w.inpa.prototype.PointRedemptionView;

import java.util.ArrayList;
import java.util.Map;

public class PointRedemptionModel {

    final static public int POINT_REDEMPTION_HEADER = 0;
    final static public int POINT_REDEMPTION_SUBTITLE = 1;
    final static public int POINT_REDEMPTION_LISTS = 2;
    final static public int POINT_REDEMPTION_SUBTOTALS = 3;
    final static public int POINT_REDEMPTION_SUBMIT = 4;

    final static public int POINT_REDEMPTION_HEADER_TITLE = 100;
    public String pointRedeemHeaderTitle;
    final static public int POINT_REDEMPTION_HEADER_STEPS = 101;
    public String pointRedeemHeaderSteps;

    final static public int POINT_REDEMPTION_SUBTITLE_TITLE = 200;
    public String pointRedeemSubtitleTitle;
    final static public int POINT_REDEMPTION_SUBTITLE_POINTS = 201;
    public String pointRedeemSubtitlePoints;

    public ArrayList<PointRedemptionListModel> pointRedeemLists;

    final static public int POINT_REDEMPTION_SUBTOTALS_BALANCE = 300;
    public String pointRedeemSubtotalsBalance;
    final static public int POINT_REDEMPTION_SUBTOTALS_AMOUNT = 301;
    public String pointRedeemSubtotalsAmount;

    int type = 0;

    public PointRedemptionModel(int type)
    {
        this.type = type;
    }

    public PointRedemptionModel(int type, Map<Integer, String> data)
    {
        this.type = type;

        switch (type)
        {
            case POINT_REDEMPTION_HEADER:

                this.pointRedeemHeaderTitle = data.get(POINT_REDEMPTION_HEADER_TITLE);
                this.pointRedeemHeaderSteps = data.get(POINT_REDEMPTION_HEADER_STEPS);

                break;

            case POINT_REDEMPTION_SUBTITLE:

                this.pointRedeemSubtitleTitle = data.get(POINT_REDEMPTION_SUBTITLE_TITLE);
                this.pointRedeemSubtitlePoints = data.get(POINT_REDEMPTION_SUBTITLE_POINTS);

                break;


            case POINT_REDEMPTION_SUBTOTALS:

                this.pointRedeemSubtotalsBalance = data.get(POINT_REDEMPTION_SUBTOTALS_BALANCE);
                this.pointRedeemSubtotalsAmount =  data.get(POINT_REDEMPTION_SUBTOTALS_AMOUNT);

                break;

            case POINT_REDEMPTION_SUBMIT:

                break;

        }
    }

    public PointRedemptionModel(int type, ArrayList<PointRedemptionListModel> pointRedeemLists)
    {
        this.type = type;
        this.pointRedeemLists = pointRedeemLists;
    }

}
