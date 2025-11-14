import java.util.Comparator;

/**
 * Write a description of class ComparatorVehicleArrivingStep here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparatorVehicleArrivingStep implements Comparator <ElectricVehicle>
{
    /**
     * Constructor for objects of class ComparatorVehicleArrivingStep
     */
    public int compare (ElectricVehicle v1, ElectricVehicle v2)
    {
        if (v1.getArrivingStep() == v2.getArrivingStep())
            return new ComparatorVehiclePlate().compare (v1,v2);
        else{
            if (v1.getArrivingStep() > v2.getArrivingStep())
                return 1;
            else
                return -1;
        }
    }
}