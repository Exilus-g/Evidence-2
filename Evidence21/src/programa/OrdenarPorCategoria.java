package programa;

import java.util.*;

/**
 * This class implements the Comparator interface to define a custom sorting order for Papeleria objects based on their category.
 */
class OrdenarPorCategoria implements Comparator<Papeleria> {

    /**
     * Compares two Papeleria objects based on their category.
     *
     * @param p1 the first Papeleria object to compare
     * @param p2 the second Papeleria object to compare
     * @return a negative integer if p1's category is less than p2's category, zero if they are equal, or a positive integer if p1's category is greater than p2's category
     */
    public int compare(Papeleria p1, Papeleria p2) {
        return p1.getCategoria().compareTo(p1.getCategoria());
    }
}
