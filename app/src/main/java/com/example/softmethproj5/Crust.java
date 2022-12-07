package com.example.softmethproj5;

/**
 * This enum class defines the six different Crusts that a pizza can have, determined based on
 * what style and flavor of pizza is chosen by the user. This enum class also contains a toString() method that defines
 * a textual representation of a Crust object.
 *
 * @author Adwait Ganguly, Kennan Guan
 */
public enum Crust {
    BROOKLYN,
    THIN,
    HANDTOSSED,
    DEEPDISH,
    PAN,
    STUFFED;

    /**
     * This method constructs a textual representation of each Crust object.
     * @return a textual representation of a crust object.
     */
    @Override
    public String toString() {
        switch(this) {
            case BROOKLYN:
                return "Brooklyn";
            case THIN:
                return "Thin";
            case HANDTOSSED:
                return "Handtossed";
            case DEEPDISH:
                return "Deep Dish";
            case PAN:
                return "Pan";
            case STUFFED:
                return "Stuffed";
        }
        return null;
    }
}