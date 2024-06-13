package com.esde.third_party_service.impl;

import com.esde.exception.PaymentProcessException;
import com.esde.model.CardPayment;
import com.esde.third_party_service.PaymentProcessService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProcessServiceImpl implements PaymentProcessService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void processPayment(CardPayment payment) throws PaymentProcessException {
        if (payment.getCardNumber().isEmpty() || payment.getCartHolderName().isEmpty() || payment.getAmount()<= 0){
            throw new PaymentProcessException("Empty payment");
        }
       String message = "Payment success, thanks " + payment.getCartHolderName();
       logger.info(message);
    }
}
