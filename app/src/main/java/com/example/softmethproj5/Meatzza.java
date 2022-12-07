package com.example.softmethproj5;
import java.util.*;

/**
 * This class defines a Meatzza Pizza that will be part of an order.
 * This class implements a constructor for an instance of a Meatzza Pizza, as well as a price() method that return the price of the pizza
 * and a toString() method that creates a textual representation of the Pizza.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class Meatzza extends Pizza {

    /**
     * This method constructs a Meatzza Pizza based on the Crust and Size inputted by the user.
     * @param crust is an instance of a Crust enum object.
     * @param size is an instance of a Size enum object.
     */
    public Meatzza (Crust crust, Size size) {
        super(new ArrayList<Topping>(Arrays.asList(Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF, Topping.HAM)), crust, size);
    }

    /**
     * This method computes the price of the Meatzza pizza based on its size.
     * @return the price of the Meatzza pizza based on its size.
     */
    public double price () {
        return this.getSize().getMeatzzaPrice();
    }

    /**
     * This method creates a textual representation of a Meatzza pizza based on its crust, style, and toppings as well as price.
     * @return a textual representation of a Meatzza pizza.
     */
    @Override
    public String toString() {
        if (this.getCrust().toString().equalsIgnoreCase("Stuffed")) {
            return ("Meatzza (Chicago Style - Stuffed), Sausage, Pepperoni, Beef, Ham, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getMeatzzaPrice()));
        }
        else {
            return ("Meatzza (New York Style - HandTossed), Sausage, Pepperoni, Beef, Ham, " + this.getSize().toString() + ", $" + String.valueOf(this.getSize().getMeatzzaPrice()));        }
    }
}