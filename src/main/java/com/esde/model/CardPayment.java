package com.esde.model;

public class CardPayment {
    private String cardNumber;
    private String cartHolderName;
    private double amount;

    public CardPayment(String cardNumber, String cartHolderName, double amount) {
        this.cardNumber = cardNumber;
        this.cartHolderName = cartHolderName;
        this.amount = amount;
    }

    public CardPayment() {
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCartHolderName() {
        return cartHolderName;
    }

    public void setCartHolderName(String cartHolderName) {
        this.cartHolderName = cartHolderName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "bankNumber='" + cardNumber + '\'' +
                ", cartHolderName='" + cartHolderName + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardPayment that = (CardPayment) o;

        if (Double.compare(amount, that.amount) != 0) return false;
        if (!cardNumber.equals(that.cardNumber)) return false;
        return cartHolderName.equals(that.cartHolderName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = cardNumber.hashCode();
        result = 31 * result + cartHolderName.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
