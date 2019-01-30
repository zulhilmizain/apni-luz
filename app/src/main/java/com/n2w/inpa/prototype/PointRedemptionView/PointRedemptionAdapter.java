package com.n2w.inpa.prototype.PointRedemptionView;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class PointRedemptionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<PointRedemptionModel> mData;
    private Activity mCont;

    public PointRedemptionAdapter(Activity mCont, ArrayList<PointRedemptionModel> mData) {

        this.mInflater = LayoutInflater.from(mCont);
        this.mData = mData;
        this.mCont = mCont;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        switch (i)
        {
            case PointRedemptionModel.POINT_REDEMPTION_HEADER:
                v = mInflater.inflate(R.layout.point_redemption_header, viewGroup, false);
                return new PointRedemptionHeaderViewHolder(v);

            case PointRedemptionModel.POINT_REDEMPTION_SUBTITLE:
                v = mInflater.inflate(R.layout.point_redemption_subtitle, viewGroup, false);
                return new PointRedemptionSubtitleViewHolder(v);

            case PointRedemptionModel.POINT_REDEMPTION_LISTS:
                v = mInflater.inflate(R.layout.point_redemption_list, viewGroup, false);
                return new PointRedemptionListsViewHolder(v);

            case PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS:
                v = mInflater.inflate(R.layout.point_redemption_point_subtotal, viewGroup, false);
                return new PointRedemptionSubtotalViewHolder(v);

            case PointRedemptionModel.POINT_REDEMPTION_SUBMIT:
                v = mInflater.inflate(R.layout.point_redemption_submit, viewGroup, false);
                return new PointRedemptionSubmitViewHolder(v);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        PointRedemptionModel data = mData.get(i);

        switch (i)
        {
            case PointRedemptionModel.POINT_REDEMPTION_HEADER:
                break;

            case PointRedemptionModel.POINT_REDEMPTION_SUBTITLE:

                ((PointRedemptionSubtitleViewHolder)viewHolder).tvPaymentSumSubTitle.setText(data.pointRedeemSubtitleTitle);
                ((PointRedemptionSubtitleViewHolder)viewHolder).tvPointRedeemSubCurrPoints.setText(data.pointRedeemSubtitlePoints);

                break;

            case PointRedemptionModel.POINT_REDEMPTION_LISTS:

                ((PointRedemptionListsViewHolder)viewHolder).rvPointRedeemList.setAdapter(new PointRedemptionListAdapter(mCont, data.pointRedeemLists));
                ((PointRedemptionListsViewHolder)viewHolder).rvPointRedeemList.setLayoutManager(new LinearLayoutManager(mCont));

                break;

            case PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS:

                ((PointRedemptionSubtotalViewHolder)viewHolder).tvPointRedeemBalance.setText(data.pointRedeemSubtotalsBalance);
                ((PointRedemptionSubtotalViewHolder)viewHolder).tvPointRedeemTotalAmount.setText(data.pointRedeemSubtotalsAmount);

                break;

            case PointRedemptionModel.POINT_REDEMPTION_SUBMIT:
                break;

                default:
                    break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (position)
        {
            case 0:
                return PointRedemptionModel.POINT_REDEMPTION_HEADER;

            case 1:
                return PointRedemptionModel.POINT_REDEMPTION_SUBTITLE;

            case 2:
                return PointRedemptionModel.POINT_REDEMPTION_LISTS;

            case 3:
                return PointRedemptionModel.POINT_REDEMPTION_SUBTOTALS;

            case 4:
                return PointRedemptionModel.POINT_REDEMPTION_SUBMIT;

            default:
               return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PointRedemptionHeaderViewHolder extends RecyclerView.ViewHolder {

        public PointRedemptionHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    public class PointRedemptionSubtitleViewHolder extends RecyclerView.ViewHolder {

        TextView tvPaymentSumSubTitle;
        TextView tvPointRedeemSubCurrPoints;

        public PointRedemptionSubtitleViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPaymentSumSubTitle = itemView.findViewById(R.id.tvPaymentSumSubTitle);
            tvPointRedeemSubCurrPoints = itemView.findViewById(R.id.tvPointRedeemSubCurrPoints);
        }
    }
    public class PointRedemptionListsViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rvPointRedeemList;

        public PointRedemptionListsViewHolder(@NonNull View itemView) {
            super(itemView);

            rvPointRedeemList = itemView.findViewById(R.id.rvPointRedeemList);
        }
    }

    public class PointRedemptionSubtotalViewHolder extends RecyclerView.ViewHolder {

        TextView tvPointRedeemBalance;
        TextView tvPointRedeemTotalAmount;

        public PointRedemptionSubtotalViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPointRedeemBalance = itemView.findViewById(R.id.tvPointRedeemBalance);
            tvPointRedeemTotalAmount = itemView.findViewById(R.id.tvPointRedeemTotalAmount);
        }
    }
    public class PointRedemptionSubmitViewHolder extends RecyclerView.ViewHolder {

        public PointRedemptionSubmitViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }



}
