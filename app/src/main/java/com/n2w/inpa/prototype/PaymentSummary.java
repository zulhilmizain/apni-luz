package com.n2w.inpa.prototype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.n2w.inpa.prototype.PaymentSummaryView.PaymentSummaryAdapter;
import com.n2w.inpa.prototype.PaymentSummaryView.PaymentSummaryBillModel;
import com.n2w.inpa.prototype.PaymentSummaryView.PaymentSummaryModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PaymentSummary extends AppCompatActivity {

    RecyclerView rvPaymentSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);

        rvPaymentSummary = findViewById(R.id.rvPaymentSummary);

        ArrayList<PaymentSummaryModel> mData = new ArrayList<>();
        ArrayList<PaymentSummaryBillModel> mBillData = new ArrayList<>();

        Map<Integer, String> mMData = new HashMap<>();
        mMData.put(PaymentSummaryModel.PAYMENTSUM_HEADER_TITLE, "Payment");
        mMData.put(PaymentSummaryModel.PAYMENTSUM_HEADER_STEPS, "Step 01");

        mData.add(new PaymentSummaryModel(PaymentSummaryModel.PAYMENTSUM_HEADER, mMData));

        mMData.clear();
        mMData.put(PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON_SUB, "Summary");
        mMData.put(PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON, "View My Trip Itinerary");

        mData.add(new PaymentSummaryModel(PaymentSummaryModel.PAYMENTSUM_SUBTITLE_BUTTON, mMData));

        mMData.clear();
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_LABEL_NO, "No.");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_LABEL_DESC, "Description");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_LABEL_QTY, "Qty");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_LABEL_AMOUNT, "Amount");

        mBillData.add(new PaymentSummaryBillModel(PaymentSummaryBillModel.PAYSUM_BILL_HEADER, mMData));

        mMData.clear();
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_NO, "1.");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_DESC, "TRIDENT");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_QTY, "1");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_AMOUNT, "RM 3,400.00");

        mBillData.add(new PaymentSummaryBillModel(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT, mMData));

        mMData.clear();
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_NO, "2.");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_DESC, "3DLabs");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_QTY, "1");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_AMOUNT, "RM 4,400.00");

        mBillData.add(new PaymentSummaryBillModel(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT, mMData));

        mMData.clear();
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_NO, "3.");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_DESC, "S3");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_QTY, "1");
        mMData.put(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT_AMOUNT, "RM 2,400.00");

        mBillData.add(new PaymentSummaryBillModel(PaymentSummaryBillModel.PAYSUM_BILL_CONTENT, mMData));

        mData.add(new PaymentSummaryModel(PaymentSummaryModel.PAYMENTSUM_LIST, mBillData));

        mMData.clear();
        mMData.put(PaymentSummaryModel.PAYMENTSUM_TOTALS_PROMO_CODE_DISC, "0.00");
        mMData.put(PaymentSummaryModel.PAYMENTSUM_TOTALS_PROMO_TAX, "260.00");
        mMData.put(PaymentSummaryModel.PAYMENTSUM_TOTALS_SUBTOTAL_AMOUNT, "6,654.32");

        mData.add(new PaymentSummaryModel(PaymentSummaryModel.PAYMENTSUM_TOTALS, mMData));

        mMData.clear();
        mData.add(new PaymentSummaryModel(PaymentSummaryModel.PAYMENTSUM_PROCEED));

        rvPaymentSummary.setAdapter(new PaymentSummaryAdapter(this, mData));
        rvPaymentSummary.setLayoutManager(new LinearLayoutManager(this));
    }
}
