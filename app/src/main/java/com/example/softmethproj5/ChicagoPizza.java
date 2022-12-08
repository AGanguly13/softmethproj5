package com.example.softmethproj5;

import java.util.*;

/**
 * This class defines a pizza of Chicago Style, and it implements the PizzaFactory interface.
 * This class implements the createDeluxe(), createBBQChicken(), createMeatzza(), and createBuildYourOwn()
 * abstract methods in the PizzaFactory interface for creating Chicago Style pizzas of different flavors.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class ChicagoPizza implements PizzaFactory {

    /**
     * This method constructs a Deluxe flavored Chicago Style Pizza with a default Deep Dish crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new Deluxe flavored Chicago Style pizza.
     */
    @Override
    public Pizza createDeluxe(Size size) {
        return new Deluxe(Crust.DEEPDISH, size);
    }

    /**
     * This method constructs a BBQChicken flavored Chicago Style Pizza with a default Pan crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new BBQChicken flavored Chicago Style pizza.
     */
    @Override
    public Pizza createBBQChicken(Size size) {
        return new BBQChicken(Crust.PAN, size);
    }

    /**
     * This method constructs a Meatzza flavored Chicago Style Pizza with a default Stuffed crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new BBQChicken flavored Chicago Style pizza.
     */
    @Override
    public Pizza createMeatzza(Size size) {
        return new Meatzza(Crust.STUFFED, size);
    }

    /**
     * This method constructs a Build Your Own flavored Chicago Style Pizza with a default Pan crust.
     * @param size is the size of the pizza that the user inputs.
     * @return a new Build Your Own Chicago Style pizza.
     */
    @Override
    public Pizza createBuildYourOwn(ArrayList<Topping> toppings, Size size) {
        return new BuildYourOwn(toppings, Crust.PAN, size);
    }
}