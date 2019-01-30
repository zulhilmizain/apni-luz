package com.n2w.inpa.prototype.SelectPeopleGoingView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;
import com.n2w.inpa.prototype.SelectTravelPreference;

import java.util.ArrayList;

public class SelectPeopleGoingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mInflater;
    Activity mActivity;
    ArrayList<SelectPeopleGoingModel> mData;

    private int adultAmount = 0;
    private int childAmount = 0;
    private int juniorAmount = 0;
    private int singleRoomAmount = 0;
    private int doubleRoomAmount = 0;
    private int familyRoomAmount = 0;

    public SelectPeopleGoingAdapter(Context cont, Activity activity, ArrayList<SelectPeopleGoingModel> mData)
    {
        this.mInflater = LayoutInflater.from(cont);
        this.mData = mData;
        this.mActivity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        switch (i)
        {
            case SelectPeopleGoingModel.HEADER:
                v = mInflater.inflate(R.layout.select_people_going_header, viewGroup, false);
                return new SelectPeopleGoingHeader(v);
            case SelectPeopleGoingModel.PEOPLE_SUBTITLE:
                v = mInflater.inflate(R.layout.select_people_going_title, viewGroup, false);
                return new SelectPeopleGoingSubtitle(v);
            case SelectPeopleGoingModel.ADULT_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingAdultSelect(v);
            case SelectPeopleGoingModel.CHILD_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingChildSelect(v);
            case SelectPeopleGoingModel.JUNIOR_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingJuniorSelect(v);
            case SelectPeopleGoingModel.ROOM_SUBTITLE:
                v = mInflater.inflate(R.layout.select_people_going_title, viewGroup, false);
                return new SelectPeopleGoingSubtitle(v);
            case SelectPeopleGoingModel.SINGLE_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingSingleRoomSelect(v);
            case SelectPeopleGoingModel.DOUBLE_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingDoubleRoomSelect(v);
            case SelectPeopleGoingModel.FAMILY_SELECT:
                v = mInflater.inflate(R.layout.select_people_going_selection, viewGroup, false);
                return new SelectPeopleGoingFamilyRoomSelect(v);
            case SelectPeopleGoingModel.NEXT_STEP_BTN:
                v = mInflater.inflate(R.layout.select_people_next_button, viewGroup, false);
                return new SelectPeopleGoingNextButton(v);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position)
        {
            case 0:
                return SelectPeopleGoingModel.HEADER;
            case 1:
                return SelectPeopleGoingModel.PEOPLE_SUBTITLE;
            case 2:
                return SelectPeopleGoingModel.ADULT_SELECT;
            case 3:
                return SelectPeopleGoingModel.CHILD_SELECT;
            case 4:
                return SelectPeopleGoingModel.JUNIOR_SELECT;
            case 5:
                return SelectPeopleGoingModel.ROOM_SUBTITLE;
            case 6:
                return SelectPeopleGoingModel.SINGLE_SELECT;
            case 7:
                return SelectPeopleGoingModel.DOUBLE_SELECT;
            case 8:
                return SelectPeopleGoingModel.FAMILY_SELECT;
            case 9:
                return SelectPeopleGoingModel.NEXT_STEP_BTN;
            default:
                return -1;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        SelectPeopleGoingModel data = mData.get(i);

        switch (i)
        {
            case SelectPeopleGoingModel.PEOPLE_SUBTITLE:
                ((SelectPeopleGoingSubtitle) viewHolder).tvSelectPeopleGoingTitle.setText(data.text);
                break;
            case SelectPeopleGoingModel.ROOM_SUBTITLE:
                ((SelectPeopleGoingSubtitle) viewHolder).tvSelectPeopleGoingTitle.setText(data.text);
                break;
            case SelectPeopleGoingModel.ADULT_SELECT:
                ((SelectPeopleGoingAdultSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingAdultSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        adultAmount--;
                        ((SelectPeopleGoingAdultSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(adultAmount));
                    }
                });

                ((SelectPeopleGoingAdultSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        adultAmount++;
                        ((SelectPeopleGoingAdultSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(adultAmount));

                    }
                });

                break;
            case SelectPeopleGoingModel.CHILD_SELECT:
                ((SelectPeopleGoingChildSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingChildSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        childAmount--;
                        ((SelectPeopleGoingChildSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(childAmount));
                    }
                });

                ((SelectPeopleGoingChildSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        childAmount++;
                        ((SelectPeopleGoingChildSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(childAmount));

                    }
                });
                break;
            case SelectPeopleGoingModel.JUNIOR_SELECT:
                ((SelectPeopleGoingJuniorSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingJuniorSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        juniorAmount--;
                        ((SelectPeopleGoingJuniorSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(juniorAmount));
                    }
                });

                ((SelectPeopleGoingJuniorSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        juniorAmount++;
                        ((SelectPeopleGoingJuniorSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(juniorAmount));

                    }
                });
                break;

            case SelectPeopleGoingModel.SINGLE_SELECT:
                ((SelectPeopleGoingSingleRoomSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingSingleRoomSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        singleRoomAmount--;
                        ((SelectPeopleGoingSingleRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(singleRoomAmount));
                    }
                });

                ((SelectPeopleGoingSingleRoomSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        singleRoomAmount++;
                        ((SelectPeopleGoingSingleRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(singleRoomAmount));

                    }
                });
                break;

            case SelectPeopleGoingModel.DOUBLE_SELECT:
                ((SelectPeopleGoingDoubleRoomSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingDoubleRoomSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        doubleRoomAmount--;
                        ((SelectPeopleGoingDoubleRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(doubleRoomAmount));
                    }
                });

                ((SelectPeopleGoingDoubleRoomSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        doubleRoomAmount++;
                        ((SelectPeopleGoingDoubleRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(doubleRoomAmount));

                    }
                });
                break;

            case SelectPeopleGoingModel.FAMILY_SELECT:
                ((SelectPeopleGoingFamilyRoomSelect)viewHolder).tvSelectPeopleGoingText.setText(data.text);

                ((SelectPeopleGoingFamilyRoomSelect)viewHolder).btnSelectPeopleGoingMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        familyRoomAmount--;
                        ((SelectPeopleGoingFamilyRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(familyRoomAmount));
                    }
                });

                ((SelectPeopleGoingFamilyRoomSelect)viewHolder).btnSelectPeopleGoingPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        familyRoomAmount++;
                        ((SelectPeopleGoingFamilyRoomSelect)viewHolder).tvSelectPeopleGoingAmount.setText(Integer.toString(familyRoomAmount));

                    }
                });
                break;

                case SelectPeopleGoingModel.NEXT_STEP_BTN:
                    ((SelectPeopleGoingNextButton) viewHolder).btnSelectPeopleNextStep.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            mActivity.startActivity(new Intent(mActivity.getApplicationContext(),SelectTravelPreference.class));

                        }
                    });
                    break;
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class SelectPeopleGoingHeader extends RecyclerView.ViewHolder{

        public SelectPeopleGoingHeader(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class SelectPeopleGoingSubtitle extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingTitle;

        public SelectPeopleGoingSubtitle(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingTitle = itemView.findViewById(R.id.tvSelectPeopleGoingTitle);
        }
    }

    public class SelectPeopleGoingAdultSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingAdultSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingChildSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingChildSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingJuniorSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingJuniorSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingSingleRoomSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingSingleRoomSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingDoubleRoomSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingDoubleRoomSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingFamilyRoomSelect extends RecyclerView.ViewHolder{

        TextView tvSelectPeopleGoingText;
        Button btnSelectPeopleGoingMinus;
        TextView tvSelectPeopleGoingAmount;
        Button btnSelectPeopleGoingPlus;

        public SelectPeopleGoingFamilyRoomSelect(@NonNull View itemView) {
            super(itemView);

            tvSelectPeopleGoingText = itemView.findViewById(R.id.tvSelectPeopleGoingText);
            btnSelectPeopleGoingMinus = itemView.findViewById(R.id.btnSelectPeopleGoingMinus);
            tvSelectPeopleGoingAmount = itemView.findViewById(R.id.tvSelectPeopleGoingAmount);
            btnSelectPeopleGoingPlus = itemView.findViewById(R.id.btnSelectPeopleGoingPlus);
        }
    }

    public class SelectPeopleGoingNextButton extends RecyclerView.ViewHolder{

        Button btnSelectPeopleNextStep;

        public SelectPeopleGoingNextButton(@NonNull View itemView) {
            super(itemView);

            btnSelectPeopleNextStep = itemView.findViewById(R.id.btnSelectPeopleNextStep);
        }
    }
}
