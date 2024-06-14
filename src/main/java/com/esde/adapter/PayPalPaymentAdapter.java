package com.esde.adapter;

import com.esde.model.CardPayment;
import com.esde.model.PayPalPayment;

public class PayPalPaymentAdapter extends CardPayment {

    private PayPalPayment payment;
    String[] paymentData;
    private final static int CARD_NUMBER_INDEX = 0;
    private final static int CARD_HOLDER_NAME_INDEX = 1;
    private final static int AMOUNT_INDEX = 2;
    private final static String DELIMETER = ", ";

    public PayPalPaymentAdapter(PayPalPayment payment){
        this.payment = payment;
        this.paymentData = payment.getPaymentInfo().split(DELIMETER);
    }

    @Override
    public String getCardNumber() {
        return paymentData[CARD_NUMBER_INDEX];
    }

    @Override
    public String getCartHolderName() {
        return paymentData[CARD_HOLDER_NAME_INDEX];
    }

    @Override
    public double getAmount() {
        return Double.parseDouble(paymentData[AMOUNT_INDEX]);
    }
}
