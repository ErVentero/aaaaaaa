import java.util.*; 

/**
 * Compares two {@link Charger} objects based on their **CharginFee** float in **ascending** order. If theres a tie, it will order by Id (String) in ascending order.
 * This is typically used as a final tie-breaker in multi-criteria sorting.
 * * @author DP Clasess
 * @version 2024.10.07
 */
public class ComparatorChargersChargerPrice implements Comparator<Charger>
{
    /**
     * Compares its two {@link Charger} arguments for order.
     * The comparison is based on the lexicographical order of their IDs.
     * @param c1 The first charger to be compared.
     * @param c2 The second charger to be compared.
     * @return A negative integer, zero, or a positive integer as the first 
     * charger's ID is lexicographically less than, equal to, or greater than the second.
     */
    public int compare(Charger c1, Charger c2)
    {
        if (c1.getChargingFee()==c2.getChargingFee()){
            return new ComparatorChargerId().compare (c1,c2);
        }
        else{
            if (c1.getChargingFee () > c2.getChargingFee()){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}