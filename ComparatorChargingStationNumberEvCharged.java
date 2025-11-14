import java.util.Comparator;

/**
 * Write a description of class ComparatorChargingStationNumberEvCharged here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorChargingStationNumberEvCharged implements Comparator <ChargingStation>
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class ComparatorChargingStationNumberEvCharged
     */
    public int compare (ChargingStation st1, ChargingStation st2)
    {
        if (st1.getNumerEVRecharged() == st2.getNumerEVRecharged())
            return new ComparatorChargingStationId().compare(st1,st2);
        else{
            if (st1.getNumerEVRecharged() < st2.getNumerEVRecharged())
                return 1;
            else
                return -1;
        }
    }
}