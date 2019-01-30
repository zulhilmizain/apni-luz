package com.n2w.inpa.prototype.SelectDateView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.n2w.inpa.prototype.DestinationViewDetails.DestinationModel;
import com.n2w.inpa.prototype.R;
import com.n2w.inpa.prototype.SelectPeopleGoing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SelectDateViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Activity mActivity;

    public ArrayList<SelectDateViewModel> mData;

    public SelectDateViewAdapter(Context cont, ArrayList<SelectDateViewModel> data, Activity activity)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mActivity = activity;
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;

        switch (i)
        {
            case SelectDateViewModel.HEADER:

                view = mInflater.inflate(R.layout.select_date_title, viewGroup, false);

                return new SelectDateHeaderViewHolder(view);

            case SelectDateViewModel.CALENDAR:

                view = mInflater.inflate(R.layout.select_date_choose, viewGroup, false);

                return new SelectCalenderViewHolder(view);

            case SelectDateViewModel.ADD_PARKS:

                view = mInflater.inflate(R.layout.select_date_add_parks, viewGroup, false);

                return new SelectAddParksViewHolder(view);

            case SelectDateViewModel.NEXT_STEP:

                view = mInflater.inflate(R.layout.select_date_next_button, viewGroup, false);

                return new SelectNextPageViewHolder(view);

        }

        return null;

    }

    @Override
    public int getItemViewType(int position) {
        switch (mData.get(position).type)
        {
            case 0:
                return SelectDateViewModel.HEADER;
            case 1:
                return SelectDateViewModel.CALENDAR;
            case 2:
                return SelectDateViewModel.ADD_PARKS;
            case 3:
                return SelectDateViewModel.NEXT_STEP;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        switch (i)
        {
            case SelectDateViewModel.CALENDAR:

                final RecyclerView.ViewHolder vH = viewHolder;
                final Calendar goCalendar = Calendar.getInstance();
                final Calendar backCalendar = Calendar.getInstance();
                final DatePickerDialog.OnDateSetListener goDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        goCalendar.set(Calendar.YEAR, year);
                        goCalendar.set(Calendar.MONTH, month);
                        goCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        backCalendar.set(Calendar.YEAR, year);
                        backCalendar.set(Calendar.MONTH, month);
                        backCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateValue(((SelectCalenderViewHolder) vH).etSelectDateChooseArrival,goCalendar);
                    }
                };

                final DatePickerDialog.OnDateSetListener backDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        goCalendar.set(Calendar.YEAR, year);
                        goCalendar.set(Calendar.MONTH, month);
                        goCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        backCalendar.set(Calendar.YEAR, year);
                        backCalendar.set(Calendar.MONTH, month);
                        backCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateValue(((SelectCalenderViewHolder) vH).etSelectDateChooseReturn,backCalendar);
                    }
                };

                ((SelectCalenderViewHolder) viewHolder).etSelectDateChooseArrival.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new DatePickerDialog(v.getContext(), goDateListener,
                                goCalendar.get(Calendar.YEAR), goCalendar.get(Calendar.MONTH),
                                goCalendar.get(Calendar.DAY_OF_MONTH)).show();

                    }
                });

                ((SelectCalenderViewHolder) viewHolder).etSelectDateChooseReturn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new DatePickerDialog(v.getContext(), backDateListener,
                                backCalendar.get(Calendar.YEAR), backCalendar.get(Calendar.MONTH),
                                backCalendar.get(Calendar.DAY_OF_MONTH)).show();

                    }
                });

                break;

            case SelectDateViewModel.NEXT_STEP:

                ((SelectNextPageViewHolder) viewHolder).btnSelectDateNextStep.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mActivity.startActivity(new Intent(mActivity,SelectPeopleGoing.class));
                    }
                });

                break;
        }



    }

    public void updateValue(EditText et, Calendar cal)
    {
        String myFormat = "dd MMMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat, Locale.UK);

        et.setText(simpleDateFormat.format(cal.getTime()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class SelectDateHeaderViewHolder extends RecyclerView.ViewHolder {

        public SelectDateHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class SelectCalenderViewHolder extends RecyclerView.ViewHolder {

        EditText etSelectDateChooseArrival;
        EditText etSelectDateChooseReturn;

        public SelectCalenderViewHolder(@NonNull View itemView) {
            super(itemView);

            etSelectDateChooseArrival = itemView.findViewById(R.id.etSelectDateChooseArrival);
            etSelectDateChooseReturn = itemView.findViewById(R.id.etSelectDateChooseReturn);
        }
    }

    public static class SelectAddParksViewHolder extends RecyclerView.ViewHolder {

        public SelectAddParksViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class SelectNextPageViewHolder extends RecyclerView.ViewHolder {

        Button btnSelectDateNextStep;

        public SelectNextPageViewHolder(@NonNull View itemView) {
            super(itemView);

            btnSelectDateNextStep = itemView.findViewById(R.id.btnSelectDateNextStep);
        }
    }
}
