package com.example.softmethproj5;
import java.util.*;

/**
 * This class is an implementation of the Customizable interface and defines an Order object. An Order object will have an int serialNumber instance variable and a
 * ArrayList of Pizzas currentOrder instance variable. This class also defines a constructor for an Order, as well as getter methods and a toString() method.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class Order implements Customizable {
    private int serialNumber;
    private ArrayList<Pizza> currentOrder;

    private static int orderCounter = 1;

    /**
     * This method is a Default Constructor that constructs a new Order object with a new serial number and an ArrayList of Pizzas.
     */
    public Order () {
        serialNumber = orderCounter;
        this.currentOrder = new ArrayList<Pizza>();
    }

    /**
     * This method updates the orderCounter variable that defines the serial number of a new order.
     */
    public void updateOrderCount() {
        orderCounter++;
    }

    /**
     * This method is overriding the add method of the Customizable interface, and it allows the user to add a pizza to an Order object.
     * @param obj is the Object being added.
     * @return true if the object is successfully added.
     */
    @Override
    public boolean add(Object obj) {
        this.currentOrder.add((Pizza) obj);
        return true;
    }

    /**
     * This method is used to clear the current order and decrement the orderCounter variable so the serial numbers remain consistent
     * when creating new orders.
     */
    public void clearOrder() {
        if (this.serialNumber > 1) {
            orderCounter--;
        }
    }

    /**
     * This method is overriding the remove method of the Customizable interface, and it allows the user to remove a pizza from an Order object.
     * @param obj is the Object being removed.
     * @return true if the object is successfully removed.
     */
    @Override
    public boolean remove(Object obj) {
        this.currentOrder.remove((Pizza) obj);
        return true;
    }

    /**
     * This is a getter method for an Order object's serial number.
     * @return the serial number of an Order.
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * This is a getter method for an Order object's ArrayList of pizzas.
     * @return the ArrayList of pizzas of an order;
     */
    public ArrayList<Pizza> getCurrentOrder() {
        return currentOrder;
    }

    /**
     * This method creates a textual representation of an order. This will be displayed to the user in the CurrentOrderView.
     * @return a textual representation of an Order object.
     */
    public String toString() {
        double totalPrice = 0.0;
        String orderString = "Order Number: " + this.getSerialNumber() +"\n";
        for (Pizza pizza: this.currentOrder) {
            orderString += pizza.toString() + "\n";
            totalPrice += pizza.price();
        }
        totalPrice *= 1.06625;
        orderString += "Order Total: $";
        orderString += String.format("%.2f", totalPrice);
        orderString += "\n\n";
        return orderString;
    }
}