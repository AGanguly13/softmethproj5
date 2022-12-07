package com.example.softmethproj5;

/**
 * This enum class defines the three different Sizes that a pizza can have, defined by the prices of each different flavor of pizza. This enum class also contains a toString() method that defines
 * a textual representation of a Size object.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public enum Size {
    SMALL(14.99, 13.99, 15.99, 8.99),
    MEDIUM(16.99, 15.99, 17.99, 10.99),
    LARGE(18.99, 17.99, 19.99, 12.99);

    private final double deluxePrice;
    private final double chickenPrice;
    private final double meatzzaPrice;
    private final double buildPrice;

    /**
     * This method constructs a Size enum object with each flavor price defined.
     * @param deluxePrice is the price of a Deluxe pizza based on the size.
     * @param chickenPrice is the price of a BBQChicken pizza based on the size.
     * @param meatzzaPrice is the price of a Meatzza pizza based on the size.
     * @param buildPrice is the price of a no topping Build Your Own pizza based on size.
     */
    Size(double deluxePrice, double chickenPrice, double meatzzaPrice, double buildPrice) {
        this.deluxePrice = deluxePrice;
        this.chickenPrice = chickenPrice;
        this.meatzzaPrice = meatzzaPrice;
        this.buildPrice = buildPrice;
    }

    /**
     * This is a getter method for the price of a Deluxe pizza.
     * @return the price of a Deluxe pizza.
     */
    public double getDeluxePrice() {
        return deluxePrice;
    }

    /**
     * This is a getter method for the price of a BBQChicken pizza.
     * @return the price of a BBQChicken pizza.
     */
    public double getChickenPrice() {
        return chickenPrice;
    }

    /**
     * This is a getter method for the price of a Meatzza pizza.
     * @return the price of a Meatzza pizza.
     */
    public double getMeatzzaPrice() {
        return meatzzaPrice;
    }

    /**
     * This is a getter method for the price of a Build Your Own pizza.
     * @return the price of a Build Your Own pizza.
     */
    public double getBuildPrice() {
        return buildPrice;
    }

    /**
     * This method creates a textual representation of each Size enum object.
     * @return a String textual representation of a Size enum object.
     */
    @Override
    public String toString() {
        switch(this) {
            case SMALL:
                return "small";
            case MEDIUM:
                return "medium";
            case LARGE:
                return "large";
        }
        return null;
    }

}