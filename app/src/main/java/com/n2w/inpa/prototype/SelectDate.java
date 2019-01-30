package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.n2w.inpa.prototype.SelectDateView.SelectDateViewAdapter;
import com.n2w.inpa.prototype.SelectDateView.SelectDateViewModel;

import java.util.ArrayList;

public class SelectDate extends AppCompatActivity {

    RecyclerView rvSelectDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);

        rvSelectDate = findViewById(R.id.rvSelectDate);

        ArrayList<SelectDateViewModel> data = new ArrayList<>();

        data.add(new SelectDateViewModel(SelectDateViewModel.HEADER));
        data.add(new SelectDateViewModel(SelectDateViewModel.CALENDAR));
        data.add(new SelectDateViewModel(SelectDateViewModel.ADD_PARKS));
        data.add(new SelectDateViewModel(SelectDateViewModel.NEXT_STEP));

        rvSelectDate.setAdapter(new SelectDateViewAdapter(this, data, this));
        rvSelectDate.setLayoutManager(new LinearLayoutManager(this));

    }
}
