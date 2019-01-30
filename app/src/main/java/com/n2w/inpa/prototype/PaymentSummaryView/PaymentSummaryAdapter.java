package com.n2w.inpa.prototype.PaymentSummaryView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.n2w.inpa.prototype.PointRedemptionActivity;
import com.n2w.inpa.prototype.R;

import java.util.ArrayList;

public class PaymentSummaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private ArrayList<PaymentSummaryModel> mData;
    private Activity mCont;

    public PaymentSummaryAdapter(Activity mCont, ArrayList<PaymentSummaryModel> mData)
    {
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
            case PaymentSummaryModel.PAYMENTSUM_HEADER:
                v = mInflater.inflate(R.layout.payment_summary_header, viewGroup,false);
                return new PaymentSummaryHeaderViewHolder(v);

            case PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON:
                v = mInflater.inflate(R.layout.payment_summary_subtitle, viewGroup, false);
                return new PaymentSummarySubtitleViewHolder(v);

            case PaymentSummaryModel.PAYMENTSUM_LIST:
                v = mInflater.inflate(R.layout.payment_summary_bill, viewGroup, false);
                return new PaymentSummaryListViewHolder(v);

            case PaymentSummaryModel.PAYMENTSUM_TOTALS:
                v = mInflater.inflate(R.layout.payment_summary_promos_totals, viewGroup, false);
                return new PaymentSummaryTotalViewHolder(v);

            case PaymentSummaryModel.PAYMENTSUM_PROCEED:
                v = mInflater.inflate(R.layout.payment_summary_submit, viewGroup, false);
                return new PaymentSummaryProceedViewHolder(v);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position)
        {
            case 0:
                return PaymentSummaryModel.PAYMENTSUM_HEADER;
            case 1:
                return PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON;
            case 2:
                return PaymentSummaryModel.PAYMENTSUM_LIST;
            case 3:
                return PaymentSummaryModel.PAYMENTSUM_TOTALS;
            case 4:
                return PaymentSummaryModel.PAYMENTSUM_PROCEED;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        PaymentSummaryModel data = mData.get(i);

        switch (i)
        {
            case PaymentSummaryModel.PAYMENTSUM_HEADER:

                ((PaymentSummaryHeaderViewHolder) viewHolder).tvPaymentSumHeaderTitle.setText(data.paymentTitle);
                ((PaymentSummaryHeaderViewHolder) viewHolder).tvPaymentSumHeaderSteps.setText(data.paymentSteps);

                break;
            case PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON:

                ((PaymentSummarySubtitleViewHolder)viewHolder).tvPaymentSumSubTitle.setText(data.paymentSubTitle);
                ((PaymentSummarySubtitleViewHolder)viewHolder).btnPaymentSumSubTripItinerary.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mCont.finish();

                    }
                });

                break;
            case PaymentSummaryModel.PAYMENTSUM_LIST:

                ((PaymentSummaryListViewHolder)viewHolder).rvPaymentSumBill.setAdapter(new PaymentSummaryBillAdapter(mCont, data.paymentContentData));
                ((PaymentSummaryListViewHolder)viewHolder).rvPaymentSumBill.setLayoutManager(new LinearLayoutManager(mCont));

                break;
            case PaymentSummaryModel.PAYMENTSUM_TOTALS:

                //((PaymentSummaryTotalViewHolder)viewHolder).etPaySumPromoCode
                //((PaymentSummaryTotalViewHolder)viewHolder).btnPaySumPromoInit
                ((PaymentSummaryTotalViewHolder)viewHolder).tvPaySumPromoDiscNum.setText(data.paymentSumPromoCodeDisc);
                ((PaymentSummaryTotalViewHolder)viewHolder).tvPaySumTaxNum.setText(data.paymentSumPromoTax);
                ((PaymentSummaryTotalViewHolder)viewHolder).tvPaySumSubTotalNum.setText(data.paymentSumSubAmount);

                break;
            case PaymentSummaryModel.PAYMENTSUM_PROCEED:

                ((PaymentSummaryProceedViewHolder)viewHolder).btnPaymentSumContineu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mCont.startActivity(new Intent(mCont, PointRedemptionActivity.class));

                    }
                });

                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PaymentSummaryHeaderViewHolder extends RecyclerView.ViewHolder {

        TextView tvPaymentSumHeaderTitle;
        TextView tvPaymentSumHeaderSteps;

        public PaymentSummaryHeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPaymentSumHeaderTitle = itemView.findViewById(R.id.tvPaymentSumHeaderTitle);
            tvPaymentSumHeaderSteps = itemView.findViewById(R.id.tvPaymentSumHeaderSteps);
        }
    }

    public class PaymentSummarySubtitleViewHolder extends RecyclerView.ViewHolder {

        TextView tvPaymentSumSubTitle;
        Button btnPaymentSumSubTripItinerary;

        public PaymentSummarySubtitleViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPaymentSumSubTitle = itemView.findViewById(R.id.tvPaymentSumSubTitle);
            btnPaymentSumSubTripItinerary = itemView.findViewById(R.id.btnPaymentSumSubTripItinerary);
        }
    }

    public class PaymentSummaryListViewHolder extends RecyclerView.ViewHolder {

        RecyclerView rvPaymentSumBill;

        public PaymentSummaryListViewHolder(@NonNull View itemView) {
            super(itemView);

            rvPaymentSumBill = itemView.findViewById(R.id.rvPaymentSumBill);
        }
    }

    public class PaymentSummaryTotalViewHolder extends RecyclerView.ViewHolder {

        EditText etPaySumPromoCode;
        Button btnPaySumPromoInit;
        TextView tvPaySumPromoDiscNum;
        TextView tvPaySumTaxNum;
        TextView tvPaySumSubTotalNum;

        public PaymentSummaryTotalViewHolder(@NonNull View itemView) {
            super(itemView);

            etPaySumPromoCode = itemView.findViewById(R.id.etPaySumPromoCode);
            btnPaySumPromoInit = itemView.findViewById(R.id.btnPaySumPromoInit);
            tvPaySumPromoDiscNum = itemView.findViewById(R.id.tvPaySumPromoDiscNum);
            tvPaySumTaxNum = itemView.findViewById(R.id.tvPaySumTaxNum);
            tvPaySumSubTotalNum = itemView.findViewById(R.id.tvPaySumSubTotalNum);
        }
    }

    public class PaymentSummaryProceedViewHolder extends RecyclerView.ViewHolder {

        Button btnPaymentSumContineu;

        public PaymentSummaryProceedViewHolder(@NonNull View itemView) {
            super(itemView);

            btnPaymentSumContineu = itemView.findViewById(R.id.btnPaymentSumContineu);
        }
    }
}
