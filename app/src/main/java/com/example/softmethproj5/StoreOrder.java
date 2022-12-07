package com.example.softmethproj5;

import java.io.PrintWriter;
import java.util.*;

/**
 * This class is an implementation of the Customizable interface and defines a StoreOrder object. A StoreOrder object will have a
 * ArrayList of Orders instance variable. This class also defines a constructor for a StoreOrder, as well as getter methods, add() and remove() methods, and an export() method to
 * export the ArrayList of orders to a separate text file.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public class StoreOrder implements Customizable {
    private ArrayList<Order> orders;

    /**
     * This method constructs a StoreOrder object based on an ArrayList of Orders.
     * @param list is an ArrayList of Order object's that will define the Store Order ArrayList instance variable.
     */
    public StoreOrder(ArrayList<Order> list) {
        this.orders = list;
    }

    /**
     * This method is overriding the add method of the Customizable interface, and it allows the user to add an order to a StoreOrder object.
     * @param obj is the Object being added.
     * @return true if the order is successfully added to the StoreOrder.
     */
    @Override
    public boolean add(Object obj) {
        this.orders.add((Order) obj);
        return true;
    }

    /**
     * This method is overriding the remove method of the Customizable interface, and it allows the user to remove an order from a StoreOrder object.
     * @param obj is the Object being removed.
     * @return true if the order is successfully removed from the StoreOrder.
     */
    @Override
    public boolean remove(Object obj) {
        this.orders.remove((Order) obj);
        return true;
    }

    /**
     * This is a getter method for the ArrayList of Orders that is an instance variable of a StoreOrder object.
     * @return an ArrayList of Orders.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * This method exports the ArrayList of Order objects to an external text file entitled 'orders.txt'."
     */
    public void export() {
        try {
            PrintWriter orderFile = new PrintWriter("orders.txt");
            for (Order o : orders) {
                orderFile.println(o.toString());
            }
            orderFile.close();
        }
        catch (Exception IOException) {

        }
    }
}