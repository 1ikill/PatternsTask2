package com.esde.main;

import com.esde.adapter.PayPalPaymentAdapter;
import com.esde.decorator.PaymentProcessDecorator;
import com.esde.decorator.PaymentProcessExceptionDecorator;
import com.esde.decorator.PaymentProcessReceiptDecorator;
import com.esde.exception.FileParsingException;
import com.esde.exception.PaymentProcessException;
import com.esde.factory.PayPalPaymentFactory;
import com.esde.factory.impl.PayPalPaymentFactoryImpl;
import com.esde.model.PayPalPayment;
import com.esde.reader.JsonReader;
import com.esde.repository.PaymentRepository;
import com.esde.third_party_service.PaymentProcessService;
import com.esde.third_party_service.impl.PaymentProcessServiceImpl;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws PaymentProcessException, FileParsingException {
        // Reading data from json to repository
        JsonReader reader = new JsonReader();
        PaymentRepository repository = new PaymentRepository(
                reader.readFromJsonFile("src/main/resources/payments.json")
        );

        //Creating default service, finding payment in repository and processing it using adapter
        PaymentProcessService paymentService = new PaymentProcessServiceImpl();
        Optional<PayPalPayment> foundPayment = repository.findPaymentsByCardHolderName("Sophia Clark");

        PayPalPaymentAdapter paymentAdapter = new PayPalPaymentAdapter(foundPayment.get());
        paymentService.processPayment(paymentAdapter);

        //Creating Decorator and processing same payment with receipt logging
        PaymentProcessDecorator decorator = new PaymentProcessReceiptDecorator(paymentService);
        decorator.processPayment(paymentAdapter);

        //Creating single payment with not enough data using factory, adding it to repository, processing it with error-handling decorator
        PayPalPaymentFactory factory = new PayPalPaymentFactoryImpl();
        PayPalPayment payPalPayment = factory.createPayment(", Taras Rybin, 100");
        repository.addPayment(payPalPayment);
        PaymentProcessDecorator decorator1 = new PaymentProcessExceptionDecorator(new PaymentProcessReceiptDecorator(paymentService));
        decorator1.processPayment(new PayPalPaymentAdapter(payPalPayment));


        //Processing same payment with not enough data with default service - will cause an exception
        decorator.processPayment(new PayPalPaymentAdapter(payPalPayment));


    }
}