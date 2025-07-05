package com.customerCheckout;

public class Customer {
    private double balance;

    public Customer(double balance) {
        setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance)
    {
        if (balance < 0)
            throw new IllegalArgumentException("Balance can't be negative.");

        this.balance = balance;
    }
}
