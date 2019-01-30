package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.n2w.inpa.prototype.SelectPeopleGoingView.SelectPeopleGoingAdapter;
import com.n2w.inpa.prototype.SelectPeopleGoingView.SelectPeopleGoingModel;

import java.util.ArrayList;

public class SelectPeopleGoing extends AppCompatActivity {

    RecyclerView rvSelectPeopleGoingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_people_going);

        rvSelectPeopleGoingView = findViewById(R.id.rvSelectPeopleGoingView);

        ArrayList<SelectPeopleGoingModel> mData = new ArrayList<>();
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.HEADER, null));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.PEOPLE_SUBTITLE, "How many people are going?"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.ADULT_SELECT, "Adult"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.CHILD_SELECT, "Child"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.JUNIOR_SELECT, "Junior"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.ROOM_SUBTITLE, "Room Preference"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.SINGLE_SELECT, "Single"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.DOUBLE_SELECT, "Double"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.FAMILY_SELECT, "Family"));
        mData.add(new SelectPeopleGoingModel(SelectPeopleGoingModel.NEXT_STEP_BTN, null));

        rvSelectPeopleGoingView.setAdapter(new SelectPeopleGoingAdapter(this, this, mData));
        rvSelectPeopleGoingView.setLayoutManager(new LinearLayoutManager(this));

    }
}
