package com.esde.model;

public class PayPalPayment {
    private String paymentInfo;

    public PayPalPayment(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public PayPalPayment() {
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayPalPayment that = (PayPalPayment) o;

        return paymentInfo.equals(that.paymentInfo);
    }

    @Override
    public int hashCode() {
        return paymentInfo.hashCode();
    }

    @Override
    public String toString() {
        return "PayPalPayment{" +
                "paymentInfo='" + paymentInfo + '\'' +
                '}';
    }
}
