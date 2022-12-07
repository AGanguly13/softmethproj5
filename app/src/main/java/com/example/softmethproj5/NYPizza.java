package com.example.softmethproj5;

import java.util.*;

/**
 * This class defines a pizza of New York Style, and it implements the PizzaFactory interface.
 * This class implements the createDeluxe(), createBBQChicken(), createMeatzza(), and createBuildYourOwn()
 * abstract methods in the PizzaFactory interface for creating New York Style pizzas of different flavors.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class NYPizza implements PizzaFactory {

    /**
     * This method constructs a Deluxe flavored New York Style Pizza with a default Brooklyn crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new Deluxe flavored New York Style pizza.
     */
    @Override
    public Pizza createDeluxe(Size size) {
        return new Deluxe(Crust.BROOKLYN, size);
    }

    /**
     * This method constructs a BBQChicken flavored New York Style Pizza with a default Thin crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new BBQChicken flavored New York Style pizza.
     */
    @Override
    public Pizza createBBQChicken(Size size) {
        return new BBQChicken(Crust.THIN, size);
    }

    /**
     * This method constructs a Meatzza flavored New York Style Pizza with a default Hand Tossed crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new Meatzza flavored New York Style pizza.
     */
    @Override
    public Pizza createMeatzza(Size size) {
        return new Meatzza(Crust.HANDTOSSED, size);
    }

    /**
     * This method constructs a Build Your Own New York Style Pizza with a default Hand Tossed crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new Build Your Own New York Style pizza.
     */
    @Override
    public Pizza createBuildYourOwn(ArrayList<Topping>toppings, Size size) {
        return new BuildYourOwn(toppings, Crust.HANDTOSSED, size);
    }
}