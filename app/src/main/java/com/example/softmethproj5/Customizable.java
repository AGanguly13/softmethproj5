package com.example.softmethproj5;

/**
 * This interface defines the add() and remove() that will be used to add or remove toppings to pizzas
 * as well as add or remove pizzas from an order.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public interface Customizable {
    /**
     * This method allows the user to add toppings from a pizza and add pizzas to their order.
     * @param obj is the Object being added.
     * @return true if the object is successfully added, false otherwise.
     */
    boolean add(Object obj);

    /**
     * This method allows the user to remove toppings from a pizza and remove pizzas to their order.
     * @param obj is the Object being removed.
     * @return true if the object is successfully removed, false otherwise.
     */
    boolean remove(Object obj);
}