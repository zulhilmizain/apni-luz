package com.n2w.inpa.prototype.PaymentSummaryView;

import java.util.ArrayList;
import java.util.Map;

public class PaymentSummaryBillModel {

    final static public int PAYSUM_BILL_HEADER = 0;
    final static public int PAYSUM_BILL_CONTENT = 1;

    final static public int PAYSUM_BILL_LABEL_NO = 100;
    public String paySumBillLabelNo;
    final static public int PAYSUM_BILL_LABEL_DESC = 101;
    public String paySumBillLabelDescription;
    final static public int PAYSUM_BILL_LABEL_QTY = 102;
    public String paySumBillLabelQty;
    final static public int PAYSUM_BILL_LABEL_AMOUNT = 103;
    public String paySumBillLabelAmount;

    final static public int PAYSUM_BILL_CONTENT_NO = 200;
    public String paySumBillContentNo;
    final static public int PAYSUM_BILL_CONTENT_DESC = 201;
    public String paySumBillContentDescription;
    final static public int PAYSUM_BILL_CONTENT_QTY = 202;
    public String paySumBillContentQty;
    final static public int PAYSUM_BILL_CONTENT_AMOUNT = 203;
    public String paySumBillContentAmount;

    public PaymentSummaryBillModel(int type, Map<Integer, String> data)
    {
        switch (type)
        {
            case PAYSUM_BILL_HEADER:

                this.paySumBillLabelNo = data.get(PAYSUM_BILL_LABEL_NO);
                this.paySumBillLabelDescription =  data.get(PAYSUM_BILL_LABEL_DESC);
                this.paySumBillLabelQty =  data.get(PAYSUM_BILL_LABEL_QTY);
                this.paySumBillLabelAmount =  data.get(PAYSUM_BILL_LABEL_AMOUNT);

                break;

            case PAYSUM_BILL_CONTENT:

                this.paySumBillContentNo = data.get(PAYSUM_BILL_CONTENT_NO);
                this.paySumBillContentDescription =  data.get(PAYSUM_BILL_CONTENT_DESC);
                this.paySumBillContentQty =  data.get(PAYSUM_BILL_CONTENT_QTY);
                this.paySumBillContentAmount =  data.get(PAYSUM_BILL_CONTENT_AMOUNT);

                break;
        }
    }


}
