package com.products;

import java.time.LocalDate;

public class ShippableExpirableProduct extends NonShippableExpirableProduct implements Shippable
{
    private double weight;

    public ShippableExpirableProduct(String name, double price, int quantity, LocalDate expireDate, double weight) {
        super(name, price, quantity, expireDate);
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public String getName() {
        return super.getName();
    }
    public int getQuantity()
    {
        return super.getQuantity();
    }
}
