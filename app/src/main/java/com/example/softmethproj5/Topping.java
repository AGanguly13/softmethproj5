package com.example.softmethproj5;

/**
 * This enum class defines the thirteen different Toppings that a pizza can have, defined by the price of each different Topping. This enum class also contains a toString() method that defines
 * a textual representation of a Topping object, as well as a getter method and a Constructor.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public enum Topping {
    SAUSAGE(1.59),
    PEPPERONI(1.59),
    GREENPEPPER(1.59),
    ONION(1.59),
    MUSHROOM(1.59),
    BBQCHICKEN(1.59),
    PROVOLONE(1.59),
    CHEDDAR(1.59),
    BEEF(1.59),
    HAM(1.59),
    PINEAPPLE(1.59),
    OLIVE(1.59),
    BUFFALOSAUCE(1.59);

    private final double price;

    /**
     * This method constructs a Topping object with the price defined.
     * @param price is the price of the Topping object.
     */
    Topping(double price) {
        this.price = price;
    }

    /**
     * This is a getter method for the price of Topping object.
     * @return a double representing the price of the topping.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * This method creates a textual representation of each Topping enum object.
     * @return a String textual representation of a Topping enum object.
     */
    public String toString() {
        switch(this) {
            case SAUSAGE:
                return "Sausage";
            case PEPPERONI:
                return "Pepperoni";
            case GREENPEPPER:
                return "GreenPepper";
            case ONION:
                return "Onion";
            case MUSHROOM:
                return "Mushroom";
            case BBQCHICKEN:
                return "BBQChicken";
            case PROVOLONE:
                return "Provolone";
            case CHEDDAR:
                return "Cheddar";
            case BEEF:
                return "Beef";
            case HAM:
                return "Ham";
            case PINEAPPLE:
                return "Pineapple";
            case OLIVE:
                return "Olive";
            case BUFFALOSAUCE:
                return "BuffaloSauce";
        }
        return null;
    }
}
