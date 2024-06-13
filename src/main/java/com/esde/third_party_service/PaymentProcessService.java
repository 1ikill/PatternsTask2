package com.esde.third_party_service;

import com.esde.exception.PaymentProcessException;
import com.esde.model.CardPayment;

public interface PaymentProcessService {

    void processPayment(CardPayment payment) throws PaymentProcessException;
}
