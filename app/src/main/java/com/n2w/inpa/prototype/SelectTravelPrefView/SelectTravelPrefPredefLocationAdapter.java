package com.n2w.inpa.prototype.SelectTravelPrefView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class SelectTravelPrefPredefLocationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mLayoutInflater;
    ArrayList<SelectTravelPrefPredefLocationModel> mData;
    Context mCont;

    public SelectTravelPrefPredefLocationAdapter(Context cont, ArrayList<SelectTravelPrefPredefLocationModel> mData)
    {
        this.mLayoutInflater = LayoutInflater.from(cont);
        this.mData = mData;
        this.mCont = cont;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = mLayoutInflater.inflate(R.layout.select_travel_preference_predef_loc, viewGroup, false);
        return new SelectTravelPrefPredefLocationViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        SelectTravelPrefPredefLocationModel data = mData.get(i);
        ((SelectTravelPrefPredefLocationViewHolder)viewHolder).txtTravelPrefPredefLocs.setText(data.text);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SelectTravelPrefPredefLocationViewHolder extends RecyclerView.ViewHolder {

        TextView txtTravelPrefPredefLocs;


        public SelectTravelPrefPredefLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTravelPrefPredefLocs = itemView.findViewById(R.id.txtTravelPrefPredefLocs);


        }
    }


}
