import java.util.List;
import java.util.ArrayList;

/**
 * Model the common elements of an Electric Vehicle (EV) that operates 
 * within the simulation, moving towards a target and potentially recharging.
 * * @author David J. Barnes and Michael Kölling
 * @author DP classes 
 * @version 2024.10.07
 */
public class ElectricVehicle 
{
    private String plate;
    private String name;
    private EVCompany company;
    private Location location;
    private Location targetLocation;
    private Location rechargingLocation;
    private int arrivingStep;
    private int idleCount;
    private int batteryCapacity;
    private int batteryLevel;
    private int kwsCharged;
    private int chargesCount;
    private float chargestCost;

    /**
     * Constructor of class ElectricVehicle.
     * @param company The EV's operating company. Must not be null.
     * @param location The EV's starting {@link Location}. Must not be null.
     * @param targetLocation The EV's final destination {@link Location}. Must not be null.
     * @param name The name of the vehicle.
     * @param plate The license plate of the vehicle.
     * @param batteryCapacity The maximum capacity of the battery.
     * @throws NullPointerException If company, location, or targetLocation is null.
     */
    public ElectricVehicle(EVCompany company, Location location, Location targetLocation, String name, String plate, int batteryCapacity)
    {
       this.company=company;
       this.location=location;
       this.targetLocation=targetLocation;
       this.rechargingLocation = null;
       this.name=name;
       this.plate=plate;
       this.batteryCapacity=batteryCapacity;
       idleCount=0;
       batteryLevel=batteryCapacity;
       kwsCharged=0;
       chargesCount=0;
       chargestCost=0;
       arrivingStep = -1;
    }
    
    
    /**
     * 
     * Copy constructor of Vehicle.
     * 
     */
    public ElectricVehicle ( ElectricVehicle otherVehicle) 
    {
       this.company= new EVCompany (otherVehicle.company);
       this.location= new Location (otherVehicle.location);
       this.targetLocation= new Location (otherVehicle.targetLocation);
       this.rechargingLocation = new Location (otherVehicle.getLocation());
       this.name=otherVehicle.name;
       this.plate=otherVehicle.plate;
       this.batteryCapacity=otherVehicle.batteryCapacity;
       this.idleCount=otherVehicle.idleCount;
       this.batteryLevel=otherVehicle.batteryLevel;
       this.kwsCharged=otherVehicle.kwsCharged;
       this.chargesCount=otherVehicle.chargesCount;
       this.chargestCost=otherVehicle.chargestCost;
       this.arrivingStep = otherVehicle.arrivingStep;
    }
    
    

    /**
     * 
     * @return the number of plate from the vehicle.
     */
    public String getPlate()
    {
        return plate;
    }
    
    /**
     *
     * @return the kws charged by the vehicle.
     */
    public int getKwsCharged()
    {
        return kwsCharged;
    }
    
    /**
     * 
     * @return the name of the vehicle   
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * 
     * @return the company from the vehicle
     */
    public EVCompany getCompany()
    {
        return company;
    }
    
    /**
     * Get the current location.
     * @return Where this vehicle is currently located.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * 
     * @return the current battery capacity .
     */
    public int getBatteryCapacity()
    {
        return batteryCapacity;
    }
    
     /**
     * 
     * @return the current battery level.
     */
    public int getBatteryLevel()
    {
        return batteryLevel;
    }
    
    /**
     * Get the final target location.
     * @return Where this vehicle is ultimately headed.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }
    
     /**
      * @return The number of simulation steps this vehicle has been idle.
      */
    public int getIdleCount()
    {
        return idleCount;
    }
    
     /**
      * @return The count of total recharges performed by this vehicle.
      */
    public int getChargesCount()
    {
        return chargesCount;
    }
    
     /**
      * @return The count of total recharges cost performed by this vehicle.
      */
    public float getChargestCost()
    {
        return chargestCost;
    }
    
    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
       this.location=location;
    }
    
    /**
     * Set the required final target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        targetLocation=location;
    }
    
    /**
     * Set the charging cost for the EV.
     * @param chargesCost The cost of charging in currency units. Must be >= 0.
     * @throws IllegalArgumentException If chargesCost is negative.
     */
    public void setChargestCost(float chargestCost)
    {
        this.chargestCost= chargestCost;
    }
    
    /**
     * Set The count of total recharges performed by this vehicle
     * @param chargeCount The charge count. Must be >= 0.
     * @throws IllegalArgumentException If chargeCount is negative.
     */
    public void setChargeCount(int chargesCount)
    {
        this.chargesCount= chargesCount;
    }
    
    /**
     * Set the license plate of the EV.
     * @param plate The license plate. Must not be null.
     * @throws NullPointerException If plate is null.
     */
    public void setPlate (String plate)
    {
        this.plate=plate;
    }
    
    /**
     * Set The name of the vehicle
     * @param name to assign. Must not be null
     * @throws NullPointerException If company is null.
     */
    public void setName (String name)
    {
        this.name=name;
    }
    
    /**
     * Set The company associated with this vehicle
     * @param company The EVCompany object. Must not be null.
     * @throws NullPointerException If company is null.
     */
    public void setCompany (EVCompany company)
    {
        this.company = new EVCompany (company);
    }
    
    /**
     * Set The idle count of the vehicle
     * @param idle count the number of times the EV has been idle. Must be >=0
     * @throws IllegalArgumentException If idleCount is negative.
     */
    public void setIdleCount (int idleCount)
    {
        this.idleCount= idleCount;
    }
    
    /**
     * Set The battery capacity of the vehicle
     * @param batteryCapacity. The total capacity in KWh. must be > 0.
     * @throws IllegalArgumentException If batteryCapacity is less than or equal to 0.
     */
    public void setBatteryCapacity (int batteryCapacity)
    {
        this.batteryCapacity=batteryCapacity;
    }
    
    /**
     * Set The current battery level of the vehicle
     * @param batteryLevel. The current battery level in kWh. Must be between 0 and batteryCapacity.
     * @throws IllegalArgumentException If batteryLevel is out of range.
     */
    public void setBatteryLevel (int batteryLevel)
    {
        this.batteryLevel=batteryLevel;
    }
    
    /**
     * Set The amount of energy charge in KWh.
     * @param kwsCharged The total kws charged. Must be >= 0.
     * @throws  IllegalArgumentException If kwsCharged is negative.
     */
    public void setKwsCharged(int kwsCharged)
    {   
        if (kwsCharged < 0) 
            throw new IllegalArgumentException("Charging cost cannot be negative");
        else
            this.kwsCharged=kwsCharged;
    }
    
    /**
     * Get the temporary recharging location.
     * @return The {@link Location} of the next {@link ChargingStation} to visit, or null if no recharge is planned.
     */
    public Location getRechargingLocation( )
    {   
        return rechargingLocation;
    }
    
    
    /**
     * Get the simulation step when the vehicle arrived at its final target location.
     * In order to work properly it has to be used before starting to move the car.
     * @return The arriving step.
     */
    public int getArrivingStep()
    {
        return arrivingStep;
    }
    
    
    /**
     * Calculates the optimal route for the vehicle. 
     * If it has battery to reach the target, {rechargingLocation} is null. If not, it saves the new recharging location in {rechargingLocation}
     */
    public void calculateRoute()
    {   
        if (enoughBattery(distanceToTheTargetLocation())){
            rechargingLocation = null;
        }
        else{
            rechargingLocation = calculateRechargingPosition();
        }
    }
    
    /**
     * Gets a string representation of the planned route, including the recharging stop if one exists.
     * @return A string showing the route: {@code currentLocation -> [rechargingLocation ->] targetLocation}.
     */
    public String getStringRoute()
    {
        StringBuilder builder = new StringBuilder ();
        
        if (hasRechargingLocation()){
            builder.append (location.toString() + ", " 
            + rechargingLocation.toString() + ", " 
            + targetLocation.toString());
            return builder.toString();
        }
        else{
            builder.append (location.toString() + ", " 
            + targetLocation.toString() );
            return builder.toString();
        }
    }
    
    
    /**
     * Checks if the current battery level is sufficient to cover a given distance.
     * @param distanceToTargetLocation The distance to check.
     * @return {@code true} if the battery level is enough, {@code false} otherwise.
     */
    public boolean enoughBattery(int distanceToTargetLocation)
    {
        return this.batteryLevel >= 5*distanceToTargetLocation;
    }
    
    /**
     * Determines the optimal intermediate {@link ChargingStation} to visit for recharging
     * if the vehicle cannot reach the final target directly.
     * Returns the location to the best chargingStation based on efficiency. (distance = min(distanceToStation + distanceToTargetFromStation) of all stations in the company)
     */
    public Location calculateRechargingPosition()
    {   
        Location optimalLocation = null;
        Location chargerLocation;
        List <ChargingStation> stations = company.getCityStations();
        int distanceLocationToCharger;
        int distanceChargerToTarget;
        int optimalDistance = Integer.MAX_VALUE;
       
        if (stations.size()>0){
                for (ChargingStation station : stations){
                
                chargerLocation= station.getLocation();
                distanceLocationToCharger = location.distance(chargerLocation);
                distanceChargerToTarget = chargerLocation.distance(targetLocation);
                
                if ((distanceLocationToCharger + distanceChargerToTarget < optimalDistance) && enoughBattery(distanceLocationToCharger) && distanceLocationToCharger != 0 ){
                    
                    optimalDistance = distanceLocationToCharger + distanceChargerToTarget;
                    optimalLocation = chargerLocation;
                    
                }
            }
        }
        return optimalLocation;
    }
    
     /**
      * Checks if the vehicle has a planned recharging stop.
      * @return Whether or not this vehicle has a recharging location set.
      */
     public boolean hasRechargingLocation(){
        return (rechargingLocation!= null);    
    }
     
    /**
     * Increment the number of steps on which this vehicle has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }
    
    /**
     * Increment the number of kWsCharged the amount you indicate on kWsCharged
     */
    
    public void incrementkwsCharged (int amountCharged)
    {
        this.kwsCharged = this.kwsCharged + amountCharged; 
    }
    
     /**
      * Get the Manhattan-like distance to the final target location from the current location.
      * @return The distance to the target location.
      */
     public int distanceToTheTargetLocation()
     {
        return this.location.distance(targetLocation);
     }

     /**
      * Simulates the recharging process when the vehicle arrives at a {@code rechargingLocation}.
      * The battery is charged to full capacity, the cost is calculated, and the location is deleted from routeLocations.
      */
    public void recharge(int step)
    {
        //We have to search the station where it is going to get charged
        ChargingStation cStation = company.getChargingStation (location);
        Charger charger = cStation.getFreeCharger();
        if (charger != null){
            int batteryRecharged = batteryCapacity - batteryLevel;
            float cost = charger.recharge( this, batteryRecharged );
            incrementCharges();
            incrementChargesCost(cost);
            calculateRoute();
            charger.setChargerFree(false); //while its recharging, it would be being used
            StringBuilder builder = new StringBuilder(); //COMPLETAR TODO
        }
        else{
            incrementIdleCount();
        }
    } 
    
    /**
     * Increments the count of recharges performed by this vehicle.
     */
    public void incrementCharges()
    {
         chargesCount++;
    }
    
    /**
     * Adds a cost amount to the total charges cost.
     * @param cost The cost of the last recharge.
     */
    public void incrementChargesCost(float cost)
    {
         chargestCost=chargestCost+cost;
    }   
     
     /**
      * Carries out a single step of the vehicle's actions.
      * Moves one step towards the target (recharging or final) or stays idle.
      * @param step The current step of the simulation.
      */
     public void act(int step)
    {
        if (arrivingStep != -1){            //If it has reached its target, we get into the if
            incrementIdleCount();
        }
        else{
            if (!enoughBattery(distanceToTheTargetLocation()) && rechargingLocation == null ){      //if this happens, the vehicle cannot move anywhere
                incrementIdleCount();
            }
            else{           //if we are here, it can move to a rechargingLocation or to it target
                if (hasRechargingLocation()){        //if we get in here, it can reach a chargingLocation and has to
                    location = location.nextLocation(rechargingLocation);
                    reduceBatteryLevel();
                    if (location.equals(rechargingLocation)){
                        recharge(step);
                    }
                }
                else{       //if we are here, the vehicle can reach the target location and has to 
                    location = location.nextLocation(targetLocation);
                    reduceBatteryLevel();
                    if (location.equals(targetLocation)){
                        arrivingStep = step;
                    }
                }
            }
        }
    }

     
    
    /**
     * Reduces the battery level by the cost of one movement step (defined in {@link EVCompany#MOVINGCOST}).
     * Ensures the battery level does not go below zero.
     */
    public void reduceBatteryLevel(){
        if (this.batteryLevel - 5 > 0){
            this.batteryLevel = this.batteryLevel - 5;
        }
    }

    
    /**
     * Returns a detailed string representation of the electric vehicle.
     * @return A string containing the vehicle's name, plate, battery info, charge counts, costs, idle count, and route.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder ();
        
        builder.append (name);
        builder.append(",");
        builder.append(plate);
        builder.append(",");
        builder.append(batteryCapacity + "kwh");
        builder.append(",");
        builder.append(batteryLevel + "kwh");
        builder.append(",");
        builder.append(chargesCount);
        builder.append(",");
        builder.append(chargestCost + "€");
        builder.append(",");
        builder.append(idleCount);
        builder.append(",");
        builder.append(getStringRoute());
        
        return builder.toString ();
    }

    /**
     * Generates a string containing the vehicle's details prefixed with the current step number.
     * @param step The current simulation step.
     * @return A formatted string for a step log.
     */
    public String getStepInfo(int step){
        
        StringBuilder builder = new StringBuilder ();
        
        builder.append ("Step: " + step + " - " + "ElectricVehicle: " +  this.toString());
        
        return builder.toString();
        
    }
    
    /**
     * Generates a string of the vehicle's initial or final status for summary display.
     * @return The output of {@link #toString()} wrapped in parentheses.
     */
    public String getInitialFinalInfo(){
         StringBuilder builder = new StringBuilder ();
         builder.append ("(ElectricVehicle: " + this.toString() + ")");
         return builder.toString();
    }
}