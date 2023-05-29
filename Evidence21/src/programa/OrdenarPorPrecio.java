package programa;

import java.util.*;

/**
 * This class implements the Comparator interface to define a custom sorting order for Papeleria objects based on their price.
 */
class OrdenarPorPrecio implements Comparator<Papeleria> {

    /**
     * Compares two Papeleria objects based on their price.
     *
     * @param p1 the first Papeleria object to compare
     * @param p2 the second Papeleria object to compare
     * @return a negative integer if p1's price is less than p2's price,
     *         zero if they are equal, or a positive integer if p1's price is greater than p2's price
     */
    public int compare(Papeleria p1, Papeleria p2) {
        return p1.getPrecio().compareTo(p2.getPrecio());
    }
}
