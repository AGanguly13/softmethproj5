package com.example.softmethproj5;
import java.util.*;

/**
 * This class defines a BBQChicken Pizza that will be part of an order.
 * This class implements a constructor for an instance of a BBQChicken Pizza, as well as a price() method that return the price of the pizza
 * and a toString() method that creates a textual representation of the Pizza.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class BBQChicken extends Pizza {

    /**
     * This method constructs a BBQChicken Pizza based on the Crust and Size inputted by the user.
     * @param crust is an instance of a Crust enum object.
     * @param size is an instance of a Size enum object.
     */
    public BBQChicken (Crust crust, Size size) {
        super(new ArrayList<Topping>(Arrays.asList(Topping.BBQCHICKEN, Topping.GREENPEPPER, Topping.PROVOLONE, Topping.CHEDDAR)), crust, size);
    }

    /**
     * This method computes the price of the BBQChicken pizza based on its size.
     * @return the price of the BBQ pizza based on its size.
     */
    public double price () {
        return this.getSize().getChickenPrice();
    }

    /**
     * This method creates a textual representation of a BBQChicken pizza based on its crust, style, and toppings as well as price.
     * @return a textual representation of a BBQChicken pizza.
     */
    @Override
    public String toString() {
        if (this.getCrust().toString().equalsIgnoreCase("Pan")) {
            return ("BBQChicken (Chicago Style - Pan), BBQChicken, GreenPepper, Provolone, Cheddar, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getChickenPrice()));
        }
        else {
            return ("BBQChicken (New York Style - Thin), BBQChicken, GreenPepper, Provolone, Cheddar, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getChickenPrice()));
        }
    }

}