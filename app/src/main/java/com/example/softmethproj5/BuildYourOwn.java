package com.example.softmethproj5;

import java.util.*;

/**
 * This class defines a Build Your Own Pizza that will be part of an order.
 * This class implements a constructor for an instance of a Build Your Own Pizza, as well as a price() method that return the price of the pizza
 * and a toString() method that creates a textual representation of the Pizza.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class BuildYourOwn extends Pizza {
    /**
     * This method constructs a BBQChicken Pizza based on the Crust and Size, and different Toppings inputted by the user.
     * @param toppings is an ArrayList of up to 7 different toppings chosen by the user.
     * @param crust is an instance of a Crust enum object.
     * @param size is an instance of a Size enum object.
     */
    public BuildYourOwn (ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    /**
     * This method computes the price of the Build Your Own pizza based on its size and the amount of toppings chosen by the user.
     * @return the price of the Build Your Own pizza based on its size and toppings.
     */
    public double price () {
        double price = this.getSize().getBuildPrice();
        for (int z = 0; z < this.getToppings().size(); z++) {
            price += this.getToppings().get(z).getPrice();
        }
        return price;
    }

    /**
     * This method creates a textual representation of a Build Your Own pizza based on its crust, style, and toppings as well as price.
     * @return a textual representation of a Build Your Own pizza.
     */
    @Override
    public String toString() {
        String s = "Build your own (";
        if (this.getCrust().toString().equalsIgnoreCase("Pan")) {
            s += "Chicago Style - Pan), ";
            for (Topping t: this.getToppings()) {
                s += t.toString() + ", ";
            }
            s += this.getSize().toString() + ", $" + String.valueOf(this.price());
        }
        else {
            s += "New York Style - HandTossed), ";
            for (Topping t: this.getToppings()) {
                s += t.toString() + ", ";
            }
            s += this.getSize().toString() + ", $" + String.valueOf(this.price());
        }
        return s;
    }
}