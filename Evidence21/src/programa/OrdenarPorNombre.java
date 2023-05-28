package programa;

import java.util.*;

/**
 * This class implements the Comparator interface to define a custom sorting order for Papeleria objects based on their name.
 */
class OrdenarPorNombre implements Comparator<Papeleria> {

    /**
     * Compares two Papeleria objects based on their name.
     *
     * @param p1 the first Papeleria object to compare
     * @param p2 the second Papeleria object to compare
     * @return a negative integer if p1's name is lexicographically less than p2's name,
     *         zero if they are equal, or a positive integer if p1's name is lexicographically greater than p2's name
     */
    public int compare(Papeleria p1, Papeleria p2) {
        return p1.getNombre().compareTo(p1.getNombre());
    }
}
