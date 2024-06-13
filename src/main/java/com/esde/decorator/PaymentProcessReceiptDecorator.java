package com.esde.decorator;

import com.esde.exception.PaymentProcessException;
import com.esde.model.CardPayment;
import com.esde.third_party_service.PaymentProcessService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentProcessReceiptDecorator extends PaymentProcessDecorator {
    private static final Logger logger = LogManager.getLogger();

    public PaymentProcessReceiptDecorator(PaymentProcessService wrapped) {
        super(wrapped);
    }

    @Override
    public void processPayment(CardPayment payment) throws PaymentProcessException {
        super.processPayment(payment);
        String receipt = String.format("Receipt\nCard Number: **** **** **** %s\nCard Holder: %s\nAmount: $%.2f",
                payment.getCardNumber().substring(payment.getCardNumber().length() - 4),
                payment.getCartHolderName(), payment.getAmount());
        logger.info(receipt);
    }
}
