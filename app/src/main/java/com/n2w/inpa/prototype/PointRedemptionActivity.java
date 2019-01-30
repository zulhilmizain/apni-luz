package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.n2w.inpa.prototype.PaymentSummaryView.PaymentSummaryBillModel;
import com.n2w.inpa.prototype.PaymentSummaryView.PaymentSummaryModel;
import com.n2w.inpa.prototype.PointRedemptionView.PointRedemptionAdapter;
import com.n2w.inpa.prototype.PointRedemptionView.PointRedemptionListModel;
import com.n2w.inpa.prototype.PointRedemptionView.PointRedemptionModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PointRedemptionActivity extends AppCompatActivity {

    RecyclerView rvPointRedemption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_redemption);

        rvPointRedemption = findViewById(R.id.rvPointRedemption);

        ArrayList<PointRedemptionModel> mData = new ArrayList<>();
        ArrayList<PointRedemptionListModel> mPointsData = new ArrayList<>();

        Map<Integer, String> mMData = new HashMap<>();
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_HEADER_TITLE, "Payment");
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_HEADER_STEPS, "Step 01");

        mData.add(new PointRedemptionModel(PointRedemptionModel.POINT_REDEMPTION_HEADER, mMData));

        mMData.clear();
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_SUBTITLE_TITLE, "Point Redemption");
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_SUBTITLE_POINTS, "Current point: 1100");

        mData.add(new PointRedemptionModel(PointRedemptionModel.POINT_REDEMPTION_SUBTITLE, mMData));

        mPointsData.add(new PointRedemptionListModel("200 points","RM 5"));
        mPointsData.add(new PointRedemptionListModel("400 points","RM 10"));
        mPointsData.add(new PointRedemptionListModel("600 points","RM 15"));

        mData.add(new PointRedemptionModel(PointRedemptionModel.POINT_REDEMPTION_LISTS, mPointsData));

        mMData.clear();
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS_BALANCE, "Points balance: 600");
        mMData.put(PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS_AMOUNT, "RM 4,456.78");

        mData.add(new PointRedemptionModel(PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS, mMData));

        mData.add(new PointRedemptionModel(PointRedemptionModel.POINT_REDEMPTION_SUBMIT, mMData));

        rvPointRedemption.setAdapter(new PointRedemptionAdapter(this, mData));
        rvPointRedemption.setLayoutManager(new LinearLayoutManager(this));
    }
}
