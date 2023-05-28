package programa;

import java.util.*;

class OrdenarPorNombre implements Comparator<Papeleria> 
{
   public int compare(Papeleria p1, Papeleria p2)
    {
        return p1.getNombre().compareTo(p1.getNombre());
    }
}