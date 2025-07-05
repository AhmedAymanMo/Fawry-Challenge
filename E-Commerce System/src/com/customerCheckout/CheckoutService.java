package com.customerCheckout;

import com.carts.Cart;
import com.carts.CartItem;
import com.products.Expirable;
import com.products.Shippable;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService
{
    public static void checkout(Customer customer, Cart cart)
    {

        if (cart.getCartItems().isEmpty())
            throw new IllegalArgumentException("Cart is empty");

        List<Shippable>Shippables = new ArrayList<>();
        List<Integer>quantity = new ArrayList<>();

        double subtotal = 0;
        for(CartItem item:cart.getCartItems())
        {
            subtotal += item.getProduct().getPrice()*item.getQuantity();
            if(item.getProduct() instanceof Shippable)
            {
                Shippables.add((Shippable) item.getProduct());
                quantity.add(item.getQuantity());
            }
            if(item.getProduct() instanceof Expirable && ((Expirable) item.getProduct()).isExpired())
            {
                throw new IllegalArgumentException("The product "+item.getProduct().getName()+" is expired");
            }
        }

        double shippingFees = ShippingService.getShipmentCost(Shippables,quantity);
        double totalCost = shippingFees+subtotal;

        if (customer.getBalance() < totalCost)
            throw new IllegalArgumentException("Insufficient balance");

        for(CartItem item:cart.getCartItems())
        {
            item.getProduct().setQuantity(item.getProduct().getQuantity() - item.getQuantity());
        }

        System.out.println("\n** Checkout receipt **");
        for(CartItem item:cart.getCartItems())
        {
            System.out.println(item.getQuantity()+"x "+item.getProduct().getName()+"        "+item.getProduct().getPrice()*item.getQuantity());
        }

        System.out.println("----------------------------");
        System.out.println("Customer balance before payment: " + customer.getBalance());
        customer.setBalance(customer.getBalance() - totalCost);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFees);
        System.out.println("Amount: " + totalCost);
        System.out.println("Customer balance after payment: " + customer.getBalance());

    }
}
