package com.products;

import java.time.LocalDate;

public class NonShippableExpirableProduct extends Product implements Expirable
{
    private LocalDate expireDate;
    public NonShippableExpirableProduct(String name, double price, int quantity,LocalDate expireDate) {
        super(name, price, quantity);
        setExpireDate(expireDate);
    }

    public void setExpireDate(LocalDate expireDate) {
        if(LocalDate.now().isAfter(expireDate))
            throw new IllegalArgumentException("Invalid date");
        this.expireDate = expireDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }
    public boolean isExpired()
    {
        return LocalDate.now().isAfter(expireDate);
    }
}
