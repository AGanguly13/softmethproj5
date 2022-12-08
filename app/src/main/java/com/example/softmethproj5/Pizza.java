package com.example.softmethproj5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is an implementation of the Customizable interface and defines a Pizza object. A Pizza object will have a Crust object instance variable, a Size object instance variable and a
 * ArrayList of Toppings instance variable. This class also defines a constructor for a Pizza, as well as getter methods and add() and remove() methods.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public abstract class Pizza implements Customizable, Serializable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * This method is a constructor for a new Pizza object based on the user input of toppings, crust choice, and size choice.
     * @param toppings is an ArrayList of Toppings selected by the user on the GUI.
     * @param crust is a Crust object based on the user selection on the GUI.
     * @param size is a Size object based on the user selection on the GUI.
     */
    public Pizza (ArrayList<Topping> toppings, Crust crust, Size size) {
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * This is an abstract method that will be implemented in the subclasses of this Pizza class.
     * @return a double representing the price of a Pizza object.
     */
    public abstract double price();

    /**
     * This method is overriding the add method of the Customizable interface, and it allows the user to add a topping to a Pizza object.
     * @param obj is the Object being added.
     * @return true if the topping is successfully added to the pizza, false otherwise.
     */
    public boolean add(Object obj) {
        if (this.toppings.contains(Topping.valueOf(obj.toString()))) {
            return false;
        }
        this.toppings.add(Topping.valueOf(obj.toString()));
        return true;
    }

    /**
     * TThis method is overriding the remove method of the Customizable interface, and it allows the user to remove a topping from a Pizza object.
     * @param obj is the Object being removed.
     * @return true if the topping is successfully removed from the pizza, false otherwise.
     */
    public boolean remove(Object obj) {
        if (this.toppings.contains(Topping.valueOf(obj.toString()))) {
            this.toppings.remove(Topping.valueOf(obj.toString()));
            return true;
        }
        return false;
    }

    /**
     * This is a getter method for a Pizza object's ArrayList of Toppings.
     * @return an ArrayList of Toppings.
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * This is a getter method for a Pizza object's Size.
     * @return the Size of a pizza.
     */
    public Size getSize() {
        return this.size;
    }

    /**
     * This is a getter method for a Pizza object's Crust.
     * @return the Crust of a pizza.
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * This is a setter method for a Pizza object's Size.
     * @param size is the size that the pizza is set to.
     */
    public void setSize(Size size) {
        this.size = size;
    }
}