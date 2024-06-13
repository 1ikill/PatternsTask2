package com.esde.factory.impl;

import com.esde.factory.PayPalPaymentFactory;
import com.esde.model.PayPalPayment;

public class PayPalPaymentFactoryImpl implements PayPalPaymentFactory {
    @Override
    public PayPalPayment createPayment(String paymentInfo) {
        return new PayPalPayment(paymentInfo);
    }
}
