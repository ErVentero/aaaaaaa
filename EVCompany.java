import java.util.*;

/**
 * Models the operation of an Electric Vehicle (EV) Company. 
 * It manages a fleet of {@link ElectricVehicle}s and a network of {@link ChargingStation}s.
 * @author DP classes
 * @version 2024.10.07
 */
public class EVCompany  
{
    private String name;
    private List<ElectricVehicle> subscribedVehicles;
    private List<ChargingStation> stations;

    /**
     * Constructor for objects of class EVCompany.
     * @param name The name of the company.
     */
    public EVCompany(String name)
    {
        this.name = name;
        subscribedVehicles = new ArrayList<ElectricVehicle> ();
        stations = new ArrayList<ChargingStation> ();
    }
    
    
    /**
     * Copy constructor of EVCompany
     */
    public EVCompany (EVCompany otherCompany)
    {
        this.name = otherCompany.name;
        this.subscribedVehicles = new ArrayList<ElectricVehicle> ();
        this.stations = new ArrayList<ChargingStation> ();
        for (ElectricVehicle ev : otherCompany.subscribedVehicles){
            this.subscribedVehicles.add( new ElectricVehicle (ev));
        }
        for (ChargingStation st : otherCompany.stations){
            this.stations.add(new ChargingStation (st));
        }
    }

     /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }
    
    
    /**
     * @return An unmodifiable list of all {@link ElectricVehicle}s.
     */
    public List<ElectricVehicle> getVehicles() 
    {
       List<ElectricVehicle> copy = new ArrayList<>();
       for (ElectricVehicle ev : subscribedVehicles) {
        copy.add(new ElectricVehicle(ev)); 
       }
       return copy;
    }
    
    /**
     * 
     * @return the reference of the list of vehicles, this is used in order to erase them from the company mainly.
     */
    
    public List <ElectricVehicle> getModifiableVehicles() 
    {
        return subscribedVehicles;
    }
    
    /**
     * @ returns the reference of the list of ChargingStations, this can be used to erase them from the company, or to just modify it.
     * 
     */
    public List <ChargingStation> getModifiableChargingStations ()
    {
        return stations;
    }
  
    /**
     * Adds an {@link ElectricVehicle} to the company's fleet.
     * @param vehicle The electric vehicle to add.
     * It will be added in ascending order by their plates.
     */
    public void addElectricVehicle(ElectricVehicle vehicle)
    {       
       int i = 0;
       boolean found = false;
       ElectricVehicle current;
       ComparatorVehiclePlate cmp = new ComparatorVehiclePlate ();
       while ( i < subscribedVehicles.size()&&!found){
           current = subscribedVehicles.get(i);
           if (cmp.compare (vehicle,current) > 0){     
               found = true;
           }
           else{
               i++;
           }
       }
       subscribedVehicles.add(i,vehicle);
    }

    
    /**
     * Adds a {@link ChargingStation} to the company's network.
     * @param station The charging station to add.
     * It will be added in ascendind order by their ids.
     */
    public void addChargingStation(ChargingStation station)
    {       
       int i = 0;
       boolean found = false;
       ChargingStation current;
       ComparatorChargingStationId cmp = new ComparatorChargingStationId();
       while ( i < stations.size()&&!found){
           current = stations.get(i);
           if (cmp.compare (station,current) > 0){     
               found = true;
           }
           else{
               i++;
           }
       }
       stations.add(i,station);
    }
    
    
    /**
     * Retrieves a {@link ChargingStation} by its unique ID.
     * @param id The ID of the station to find.
     * @return The {@link ChargingStation} with the matching ID, or {@code null} if not found.
     */
    public ChargingStation getChargingStation(String id)
    {
        for(int i=0;i<stations.size();i++){
            if(stations.get(i).getId().equals(id)){
                return stations.get(i);
            }
        }
        return null;
    }

    /**
     * Retrieves a {@link ChargingStation} by its {@link Location}.
     * @param location The {@link Location} of the station to find.
     * @return The {@link ChargingStation} at the matching location, or {@code null} if not found.
     */
    public ChargingStation getChargingStation(Location location)
    {
       for (int i = 0; i < stations.size(); i++) {
       if (stations.get(i).getLocation().equals(location)) {
           return stations.get(i); 
          }
       }
       return null;
    }

    
    /**
     * @return An unmodifiable list of all managed {@link ChargingStation}s.
     */
    public List<ChargingStation> getCityStations()
    {
      
       List<ChargingStation> copy = new ArrayList<>();
       for (ChargingStation cs : stations) {
        copy.add(new ChargingStation(cs)); 
       }
       return copy;
    
    }
    
    
    /**
     * @return The total number of managed {@link ChargingStation}s.
     */
    public int getNumberOfStations(){
        return stations.size();
    }
    
    /**
     * Clears all managed vehicles and stations, resetting the company to an empty state.
     */
    public void reset(){
        name = null;
        subscribedVehicles.clear();
        stations.clear();
    }
    
}