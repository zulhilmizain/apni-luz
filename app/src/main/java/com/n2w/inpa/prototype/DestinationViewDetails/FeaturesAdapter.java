package com.n2w.inpa.prototype.DestinationViewDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class FeaturesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflation;
    private ArrayList<FeaturesModel> mFeatModel;

    public FeaturesAdapter(Context context, ArrayList<FeaturesModel> mFeatModel)
    {
        this.mInflation = LayoutInflater.from(context);
        this.mFeatModel = mFeatModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = mInflation.inflate(R.layout.destination_details_features_inner, viewGroup, false);

        return new FeaturesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        FeaturesModel featModel = mFeatModel.get(i);

        ((FeaturesViewHolder) viewHolder).txtDestFeaturesIcon.setImageResource(featModel.imgIconDrawable);
        ((FeaturesViewHolder) viewHolder).txtDestFeaturesName.setText(featModel.featuresName);
    }

    @Override
    public int getItemCount() {
        return mFeatModel.size();
    }

    public static class FeaturesViewHolder extends RecyclerView.ViewHolder
    {
        ImageView txtDestFeaturesIcon;
        TextView txtDestFeaturesName;

        public FeaturesViewHolder(@NonNull View itemView) {
            super(itemView);

            txtDestFeaturesIcon = itemView.findViewById(R.id.txtDestFeaturesIcon);
            txtDestFeaturesName = itemView.findViewById(R.id.txtDestFeaturesName);
        }
    }
}
