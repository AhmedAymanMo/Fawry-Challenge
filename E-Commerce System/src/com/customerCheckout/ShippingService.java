package com.customerCheckout;

import com.products.Shippable;

import java.util.List;

public class ShippingService
{
    public static double getShipmentCost(List<Shippable> shippables, List<Integer>quantity)
    {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (int i = 0;i<shippables.size();i++) {
            System.out.println(quantity.get(i)+"x "+shippables.get(i).getName() + " " + shippables.get(i).getWeight()* quantity.get(i) + "g");
            totalWeight += shippables.get(i).getWeight()* quantity.get(i);
        }
        System.out.println("Total package weight "+totalWeight/1000+"kg");
        return totalWeight/1000 * 10;//I assumed that the shipping fees is dependent on the total weight
    }
}
