package com.esde.decorator;

import com.esde.exception.PaymentProcessException;
import com.esde.model.CardPayment;
import com.esde.third_party_service.PaymentProcessService;

public abstract class PaymentProcessDecorator implements PaymentProcessService {
    private PaymentProcessService wrapped;

    public PaymentProcessDecorator(PaymentProcessService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void processPayment(CardPayment payment) throws PaymentProcessException {
        wrapped.processPayment(payment);
    }
}
