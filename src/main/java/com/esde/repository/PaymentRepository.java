package com.esde.repository;

import com.esde.model.PayPalPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentRepository {
    private final List<PayPalPayment> payments;

    public PaymentRepository(List<PayPalPayment> payments) {
        this.payments = payments;
    }

    public PaymentRepository() {
        payments = new ArrayList<>();
    }

    public void addPayment(PayPalPayment payment) {
        payments.add(payment);
    }

    public List<PayPalPayment> findAllPayments() {
        return payments;
    }

    public Optional<PayPalPayment> findPaymentsByCardNumber(String cardNumber) {
        return payments.stream()
                .filter(payment -> payment.getPaymentInfo().contains(cardNumber))
                .findFirst();
    }

    public Optional<PayPalPayment> findPaymentsByCardHolderName(String cardHolderName) {
        return payments.stream()
                .filter(payment -> payment.getPaymentInfo().contains(cardHolderName))
                .findFirst();
    }

    public void removePaymentByCardNumber(String cardNumber) {
        payments.removeIf(payment -> payment.getPaymentInfo().contains(cardNumber));
    }
}
