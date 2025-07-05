package com;

import com.carts.Cart;
import com.customerCheckout.CheckoutService;
import com.customerCheckout.Customer;
import com.products.NonShippableNonExpirableProduct;
import com.products.Product;
import com.products.ShippableExpirableProduct;
import com.products.ShippableNonExpirableProduct;

import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        //TestExpireDate();
        //TestInsufficientBalance();
        //TestQuantity();
        //TestEmptyCart();
        TestSuccess();

    }

    //this will throw exception since it expired
    public static void TestExpireDate()
    {
        Product biscuits = new ShippableExpirableProduct("biscuits",400,20,LocalDate.of(2024,12,30),700);
        Customer customer = new Customer(10000);
        Cart cart = new Cart();
        cart.add(biscuits,3);
        CheckoutService.checkout(customer,cart);
    }
    //this will throw exception since the total price is more than the customer balance
    public static void TestInsufficientBalance()
    {
        Product mobile = new ShippableNonExpirableProduct("iphone",30000,5,600);
        Customer customer = new Customer(10000);
        Cart cart = new Cart();
        cart.add(mobile,1);//this will throw exception since the total price is more than the customer balance
        CheckoutService.checkout(customer,cart);
    }

    //this will throw exception since there are 3 cards only
    public static void TestQuantity()
    {
        Product card = new NonShippableNonExpirableProduct("card",50,3);
        Customer customer = new Customer(10000);
        Cart cart = new Cart();
        cart.add(card,8);
        CheckoutService.checkout(customer,cart);
    }
    public static void TestSuccess()
    {
        Product cheese = new ShippableExpirableProduct("cheese",200,10, LocalDate.of(2025,12,30),200);
        Product tv = new ShippableNonExpirableProduct("TV",6000,5,5000);
        Product card = new NonShippableNonExpirableProduct("card",50,3);
        Customer customer = new Customer(10000);

        Cart cart = new Cart();
        cart.add(cheese,2);
        cart.add(tv,1);
        cart.add(card,2);

        CheckoutService.checkout(customer,cart);
    }
    public static void TestEmptyCart()
    {
        Customer customer = new Customer(10000);
        Cart cart = new Cart();
        CheckoutService.checkout(customer,cart);
    }
}