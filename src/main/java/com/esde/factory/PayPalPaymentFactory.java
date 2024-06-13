package com.esde.factory;

import com.esde.model.PayPalPayment;

public interface PayPalPaymentFactory {
    PayPalPayment createPayment(String paymentInfo);
}
