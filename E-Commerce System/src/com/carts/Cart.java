package com.carts;

import com.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart
{
    private List<CartItem> cartItems = new ArrayList<>();

    public void add(Product product, int quantity)
    {
        if(product.getQuantity()<quantity)
            throw new IllegalArgumentException("The remaining " + product.getName()+" is not enough.There is only "+product.getQuantity());

        cartItems.add(new CartItem(product,quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
