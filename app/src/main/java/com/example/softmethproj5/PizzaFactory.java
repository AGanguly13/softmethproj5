package com.example.softmethproj5;

import java.util.ArrayList;

/**
 * This interface defines the createDeluxe(), createMeatzza(), createBBQChicken(), and createBuildYourOwn() methods that will be used to create pizzas
 * of different flavors dependent on which style of pizza is chosen by the user.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public interface PizzaFactory {

    /**
     * This method defines the common operation of creating a Deluxe flavored pizza in the NYPizza and ChicagoPizza classes.
     * @param size is the Size of the new pizza object.
     * @return a new Deluxe flavored pizza.
     */
    Pizza createDeluxe(Size size);

    /**
     * This method defines the common operation of creating a Meatzza flavored pizza in the NYPizza and ChicagoPizza classes.
     * @param size is the Size of the new pizza object.
     * @return a new Meatzza flavored pizza.
     */
    Pizza createMeatzza(Size size);

    /**
     * This method defines the common operation of creating a BBQChicken flavored pizza in the NYPizza and ChicagoPizza classes.
     * @param size is the Size of the new pizza object.
     * @return a new BBQChicken flavored pizza.
     */
    Pizza createBBQChicken(Size size);

    /**
     * This method defines the common operation of creating a Build Your Own pizza in the NYPizza and ChicagoPizza classes.
     * @param size is the Size of the new pizza object.
     * @return a new Build Your Own pizza.
     */
    Pizza createBuildYourOwn(ArrayList<Topping> toppings, Size size);
}