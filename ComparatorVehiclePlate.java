import java.util.*;

/**
 * Compares the plate of 2 ElectricVehicles in ascending order
 */
public class ComparatorVehiclePlate implements Comparator <ElectricVehicle>
{
    /**
     * Constructor for objects of class ComparatorVehiclePlate
     */
    public int compare(ElectricVehicle Ev1, ElectricVehicle Ev2)
    {
        return (Ev1.getPlate().compareTo(Ev2.getPlate()));
    }
}