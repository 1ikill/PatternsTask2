package com.esde.exception;

public class PaymentProcessException extends Exception {

    public PaymentProcessException() {

    }

    public PaymentProcessException(String message){
        super("Failed to process payment: " + message);
    }

    public PaymentProcessException(String message, Throwable cause){
        super(message, cause);
    }

    public PaymentProcessException(Throwable cause){
        super(cause);
    }
}
