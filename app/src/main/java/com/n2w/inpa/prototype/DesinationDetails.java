package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.n2w.inpa.prototype.DestinationViewDetails.DestinationModel;
import com.n2w.inpa.prototype.DestinationViewDetails.FeaturesModel;
import com.n2w.inpa.prototype.DestinationViewDetails.IconCellsModel;
import com.n2w.inpa.prototype.DestinationViewDetails.IconIICellsModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DesinationDetails extends AppCompatActivity {

    private RecyclerView mDestDetailsRecView;

    public DesinationDetails()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desination_details);

        Log.d("DestDetails","Perform RecyclerView");

        mDestDetailsRecView = findViewById(R.id.destDetailsRecView);

        ArrayList<FeaturesModel> featuresList = new ArrayList<>();
        featuresList.add(new FeaturesModel(R.drawable.ic_menu_mytrip,"Booked 1200"));
        featuresList.add(new FeaturesModel(R.drawable.ic_menu_myprofile,"Full Board"));
        featuresList.add(new FeaturesModel(R.drawable.ic_menu_discover,"Instant Booking"));

        CardPagerAdapter cpAdapter = new CardPagerAdapter(this);
        cpAdapter.addCardItem(new CardItem("POI"));
        cpAdapter.addCardItem(new CardItem("POI"));
        cpAdapter.addCardItem(new CardItem("POI"));

        ArrayList<IconCellsModel> iconCellsList = new ArrayList<>();
        iconCellsList.add(new IconCellsModel("Get ready for and adventurous 4x4 transfer."));
        iconCellsList.add(new IconCellsModel("Trekking to Takah Tempang"));
        iconCellsList.add(new IconCellsModel("Nightwalk Activity"));

        ArrayList<IconIICellsModel> iconCellsIIList = new ArrayList<>();
        iconCellsIIList.add(new IconIICellsModel(R.drawable.ic_menu_myprofile,"Conservation Fee & Insurance"));
        iconCellsIIList.add(new IconIICellsModel(R.drawable.ic_menu_myprofile,"1 Day Guide Tour"));
        iconCellsIIList.add(new IconIICellsModel(R.drawable.ic_menu_myprofile,"Meal Arrangement: Packed Lunch"));
        iconCellsIIList.add(new IconIICellsModel(R.drawable.ic_menu_myprofile,"Transportation"));

        ArrayList<DestinationModel> destLists = new ArrayList<>();
        destLists.add(new DestinationModel(DestinationModel.HEADER,"Endau Rompin Peta", "https://hikersforlife.com/wp-content/uploads/2016/06/endaurompinselaifeature.jpg"));
        destLists.add(new DestinationModel(DestinationModel.DESCRIPTION,"Lorem ipsum"));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(DestinationModel.FEATURES, featuresList));
        destLists.add(new DestinationModel(DestinationModel.POI_VIEWCARD, cpAdapter));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(DestinationModel.POINT_DESCRIPTION, iconCellsList, true));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(iconCellsIIList,DestinationModel.RULES));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(DestinationModel.LOCATION, 0.0, 0.0));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(DestinationModel.REVIEWS));
        destLists.add(new DestinationModel(DestinationModel.LINE));
        destLists.add(new DestinationModel(DestinationModel.POINT_DESCRIPTION, iconCellsList, true));
        destLists.add(new DestinationModel(DestinationModel.BOOKBUTTON));


        com.n2w.inpa.prototype.DestinationViewDetails.Adapter mViewAdapter =
                new com.n2w.inpa.prototype.DestinationViewDetails.Adapter(this, this, destLists);

        mDestDetailsRecView.setAdapter(mViewAdapter);
        mDestDetailsRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}
