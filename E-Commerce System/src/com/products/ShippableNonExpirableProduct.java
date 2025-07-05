package com.products;

public class ShippableNonExpirableProduct extends NonShippableNonExpirableProduct implements Shippable
{
    private double weight;
    public ShippableNonExpirableProduct(String name, double price, int quantity,int weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public String getName() {
        return super.getName();
    }

}
