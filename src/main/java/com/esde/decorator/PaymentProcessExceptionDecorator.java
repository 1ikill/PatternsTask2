package com.esde.decorator;

import com.esde.exception.PaymentProcessException;
import com.esde.model.CardPayment;
import com.esde.third_party_service.PaymentProcessService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProcessExceptionDecorator extends PaymentProcessDecorator {
    private final static Logger logger = LogManager.getLogger();

    public PaymentProcessExceptionDecorator(PaymentProcessService wrapped) {
        super(wrapped);
    }

    @Override
    public void processPayment(CardPayment payment){
        try {
            super.processPayment(payment);
        } catch (PaymentProcessException e){
            logger.error(e);
        }
    }
}
