package com.n2w.inpa.prototype.PointRedemptionView;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class PointRedemptionListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<PointRedemptionListModel> mData;
    private Activity mCont;

    public PointRedemptionListAdapter(Activity mCont, ArrayList<PointRedemptionListModel> mData)
    {
        this.mData = mData;
        this.mCont = mCont;
        this.mInflater = LayoutInflater.from(mCont);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = mInflater.inflate(R.layout.point_redemption_list_content, viewGroup, false);

        return new PointRedemptionListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        PointRedemptionListModel data = mData.get(i);

        ((PointRedemptionListViewHolder)viewHolder).tvPointRedeemListContentPoints.setText(data.points);
        ((PointRedemptionListViewHolder)viewHolder).tvPointRedeemListContentValue.setText(data.value);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PointRedemptionListViewHolder extends RecyclerView.ViewHolder {

        TextView tvPointRedeemListContentPoints;
        TextView tvPointRedeemListContentValue;

        public PointRedemptionListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPointRedeemListContentPoints = itemView.findViewById(R.id.tvPointRedeemListContentPoints);
            tvPointRedeemListContentValue = itemView.findViewById(R.id.tvPointRedeemListContentValue);
        }
    }
}
