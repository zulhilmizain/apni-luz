package com.n2w.inpa.prototype.PaymentSummaryView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class PaymentSummaryBillAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<PaymentSummaryBillModel> mData;

    public PaymentSummaryBillAdapter(Context mCont, ArrayList<PaymentSummaryBillModel> mData)
    {
        this.mInflater = LayoutInflater.from(mCont);
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;

        switch (i)
        {
            case PaymentSummaryBillModel.PAYSUM_BILL_HEADER:

                v = mInflater.inflate(R.layout.payment_summary_bill_header, viewGroup, false);
                return new PaymentSummaryBillHeader(v);

            default:

                v = mInflater.inflate(R.layout.payment_summary_bill_content, viewGroup, false);
                return new PaymentSummaryBillContent(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        PaymentSummaryBillModel data = mData.get(i);

        switch (i)
        {
            case PaymentSummaryBillModel.PAYSUM_BILL_HEADER:

                ((PaymentSummaryBillHeader) viewHolder).tvPaySumBillLabelNo.setText(data.paySumBillLabelNo);
                ((PaymentSummaryBillHeader) viewHolder).tvPaySumBillLabelDesc.setText(data.paySumBillLabelDescription);
                ((PaymentSummaryBillHeader) viewHolder).tvPaySumBillLabelQty.setText(data.paySumBillLabelQty);
                ((PaymentSummaryBillHeader) viewHolder).tvPaySumBillLabelAmount.setText(data.paySumBillLabelAmount);

                break;

            default:

                ((PaymentSummaryBillContent) viewHolder).tvPaySumBillContNo.setText(data.paySumBillContentNo);
                ((PaymentSummaryBillContent) viewHolder).tvPaySumBillContDesc.setText(data.paySumBillContentDescription);
                ((PaymentSummaryBillContent) viewHolder).tvPaySumBillContQty.setText(data.paySumBillContentQty);
                ((PaymentSummaryBillContent) viewHolder).tvPaySumBillContAmount.setText(data.paySumBillContentAmount);

                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        switch (position)
        {
            case 0:
                return PaymentSummaryBillModel.PAYSUM_BILL_HEADER;
            default:
                return PaymentSummaryBillModel.PAYSUM_BILL_CONTENT;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PaymentSummaryBillHeader extends RecyclerView.ViewHolder {

        TextView tvPaySumBillLabelNo;
        TextView tvPaySumBillLabelDesc;
        TextView tvPaySumBillLabelQty;
        TextView tvPaySumBillLabelAmount;

        public PaymentSummaryBillHeader(@NonNull View itemView) {
            super(itemView);

            tvPaySumBillLabelNo = itemView.findViewById(R.id.tvPaySumBillLabelNo);
            tvPaySumBillLabelDesc = itemView.findViewById(R.id.tvPaySumBillLabelDesc);
            tvPaySumBillLabelQty = itemView.findViewById(R.id.tvPaySumBillLabelQty);
            tvPaySumBillLabelAmount = itemView.findViewById(R.id.tvPaySumBillLabelAmount);
        }
    }

    public class PaymentSummaryBillContent extends RecyclerView.ViewHolder {

        TextView tvPaySumBillContNo;
        TextView tvPaySumBillContDesc;
        TextView tvPaySumBillContQty;
        TextView tvPaySumBillContAmount;

        public PaymentSummaryBillContent(@NonNull View itemView) {
            super(itemView);

            tvPaySumBillContNo = itemView.findViewById(R.id.tvPaySumBillContNo);
            tvPaySumBillContDesc = itemView.findViewById(R.id.tvPaySumBillContDesc);
            tvPaySumBillContQty = itemView.findViewById(R.id.tvPaySumBillContQty);
            tvPaySumBillContAmount = itemView.findViewById(R.id.tvPaySumBillContAmount);
        }
    }
}
