package com.example.softmethproj5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class defines a Deluxe Pizza that will be part of an order.
 * This class implements a constructor for an instance of a Deluxe Pizza, as well as a price() method that return the price of the pizza
 * and a toString() method that creates a textual representation of the Pizza.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class Deluxe extends Pizza {

    /**
     * This method constructs a Deluxe Pizza based on the Crust and Size inputted by the user.
     * @param crust is an instance of a Crust enum object.
     * @param size is an instance of a Size enum object.
     */
    public Deluxe (Crust crust, Size size) {
        super(new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREENPEPPER, Topping.ONION, Topping.MUSHROOM)), crust, size);
    }

    /**
     * This method computes the price of the Deluxe pizza based on its size.
     * @return the price of the Deluxe pizza based on its size.
     */
    public double price () {
        return this.getSize().getDeluxePrice();
    }

    /**
     * This method creates a textual representation of a Deluxe pizza based on its crust, style, and toppings as well as price.
     * @return a textual representation of a Deluxe pizza.
     */
    @Override
    public String toString() {
        if (this.getCrust().toString().equalsIgnoreCase("Deep Dish")) {
            return ("Deluxe (Chicago Style - Deep Dish), Sausage, Pepperoni, GreenPepper, Onion, Mushroom, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getDeluxePrice()));
        } else {
            return ("Deluxe (New York Style - Brooklyn), Sausage, Pepperoni, GreenPepper, Onion, Mushroom, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getDeluxePrice()));
        }
    }
}