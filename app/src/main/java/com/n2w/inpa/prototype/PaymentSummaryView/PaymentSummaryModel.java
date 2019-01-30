package com.n2w.inpa.prototype.PaymentSummaryView;

import java.util.ArrayList;
import java.util.Map;

public class PaymentSummaryModel {

    final static public int PAYMENTSUM_HEADER = 0;
    final static public int PAYMENTSUM_SUBTITLE_BUTTON = 1;
    final static public int PAYMENTSUM_LIST = 2;
    final static public int PAYMENTSUM_TOTALS = 3;
    final static public int PAYMENTSUM_PROCEED = 4;

    public int type = 0;

    final static public int PAYMENTSUM_HEADER_TITLE = 100;
    public String paymentTitle;
    final static public int PAYMENTSUM_HEADER_STEPS = 101;
    public String paymentSteps;

    final static public int PAYMENTSUM_SUBTITLE_BUTTON_SUB = 200;
    public String paymentSubTitle;
    final static public int PAYMENTSUM_SUBTITLE_BUTTON_TRIPLABEL = 201;
    public String paymentTripLabelButton;

    final static public int PAYMENTSUM_LIST_DATA = 300;
    public ArrayList<PaymentSummaryBillModel> paymentContentData;

    final static public int PAYMENTSUM_TOTALS_PROMO_CODE_INPUT = 400;
    final static public int PAYMENTSUM_TOTALS_PROMO_CODE_BUTTON = 401;
    final static public int PAYMENTSUM_TOTALS_PROMO_CODE_DISC = 402;
    public String paymentSumPromoCodeDisc;
    final static public int PAYMENTSUM_TOTALS_PROMO_TAX = 403;
    public String paymentSumPromoTax;
    final static public int PAYMENTSUM_TOTALS_SUBTOTAL_AMOUNT = 404;
    public String paymentSumSubAmount;

    final static public int PAYMENTSUM_PROCEED_BUTTON = 500;

    public PaymentSummaryModel(int type)
    {
        this.type = type;
    }


    public PaymentSummaryModel(int type, Map<Integer, String> data)
    {
        switch (type)
        {
            case PAYMENTSUM_HEADER:

                this.type = type;
                this.paymentTitle = data.get(PAYMENTSUM_HEADER_TITLE);
                this.paymentSteps =  data.get(PAYMENTSUM_HEADER_STEPS);

                break;

            case PAYMENTSUM_SUBTITLE_BUTTON:

                this.type = type;
                this.paymentSubTitle = data.get(PAYMENTSUM_SUBTITLE_BUTTON_SUB);

                break;

            case PAYMENTSUM_TOTALS:

                this.type = type;
                this.paymentSumPromoCodeDisc = data.get(PAYMENTSUM_TOTALS_PROMO_CODE_DISC);
                this.paymentSumPromoTax = data.get(PAYMENTSUM_TOTALS_PROMO_TAX);
                this.paymentSumSubAmount = data.get(PAYMENTSUM_TOTALS_SUBTOTAL_AMOUNT);

                break;
        }
    }

    public PaymentSummaryModel(int type, ArrayList<PaymentSummaryBillModel> data)
    {
        this.type = type;
        this.paymentContentData = data;
    }

}
