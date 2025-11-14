import java.util.ArrayList;
import java.util.List;
/**
 * Model a charger unit within a {@link ChargingStation}.
 * It tracks its charging capabilities, fee, and the electric vehicles it has recharged.
 * * @author David J. Barnes and Michael Kölling
 * @author DP classes 
 * @version 2024.10.07
 */
public class Charger
{
    private String id; //7 caracteres que contienen el id de la estación de carga en la que se encuentra seguido de '_' y dos dígitos
    private int chargingSpeed;
    private float chargingFee;
    private List<ElectricVehicle> eVsRecharged;
    private float amountCollected;
    private boolean free;

    /**
     * Constructor for objects of class Charger.
     * @param id The unique identifier of the charger.
     * @param speed The maximum charging speed in kWh.
     * @param fee The cost per kWh for charging.
     */
    public Charger(String id, int speed, float fee)
    {
        this.id = id;
        chargingSpeed = speed;
        chargingFee = fee;
        eVsRecharged = new ArrayList <ElectricVehicle> ();
        amountCollected = 0;
        free = true;
    }
    
    /**
     * Copy constructor of Charger
     */
    public Charger (Charger otherCharger)
    {
        this.id = id;
        this.chargingSpeed = otherCharger.chargingSpeed;
        this.chargingFee = otherCharger.chargingFee;
        this.eVsRecharged = new ArrayList <ElectricVehicle> ();
        this.amountCollected = otherCharger.amountCollected;
        this.free = otherCharger.free;
            
        //Copy of every single vehicle in the new arraylist, not the reference.
        
        for (int i = 0; i < otherCharger.eVsRecharged.size(); i++){
            ElectricVehicle vehicle = new ElectricVehicle (otherCharger.eVsRecharged.get(i));
            this.eVsRecharged.add(vehicle);
        }
    }
    
    
    /**
     * Get the current id.
     * @return the id of the charger.
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Get the current charger speed.
     * @return the speed of the charger.
     */
    public int getChargingSpeed()
    {
        return chargingSpeed;
    }
    
    /**
     * Get the current charger fee.
     * @return the fee of the charger.
     */
    public float getChargingFee()
    {
        return chargingFee;
    }
    
    /**
     * Get the current list of EVs recharged in this charger.
     * @return the list of EVs recharged in this charger.
     */
    public List<ElectricVehicle> getEVsRecharged()
    {
        return eVsRecharged;
    }
    
    /**
     * Get the current amount of money collected.
     * @return the amount of money collected by the charger.
     */
    public float getAmountCollected()
    {  
        return amountCollected; 
    }
    
    /**
     * Get the current occupation state of the charger.
     * @return true if the charger is free and false if the charger is not free (in use).
     */
    public boolean getChargerFree()
    {
        return free;
    }
    
    
    /**
     * Set the current id.
     * @param id. Must not be null.
     * @throws NullPointerException If id is null.
     */
    public void setId(String id)
    {
        this.id = id;
    }
    
    /**
     * Set the current charger speed.
     * @param chargingSpeed
     */
    public void setChargingSpeed(int chargingSpeed)
    {
        this.chargingSpeed = chargingSpeed;
    }
    
    /**
     * Set the current charger fee.
     * @param chargingFee
     */
    public void setChargingFee(float chargingFee)
    {
        this.chargingFee = chargingFee;
    }
    
    /**
     * Set the current list of EVs recharged by the charger.
     * @param eVsRecharged. Must be a list of ElectricVehicle class
     */
    public void setEVsRecharged(List<ElectricVehicle> eVsRecharged)
    {
        this.eVsRecharged = eVsRecharged;
    }
    
    /**
     * Set the current amount of money collected by the charger.
     * @param amountCollected
     */
    public void setAmountCollected(float amountCollected)
    {
        this.amountCollected = amountCollected;
    }
    
    /**
     * Set the current occupation state of the charger.
     * @param free. True if want to set to free and false if want to set to occupated (in use)
     */
    public void setChargerFree(boolean free)
    {
        this.free = free;
    }
    
    
    /**
     * Returns a string representation of the charger, including its ID, speed, fee, and the number of EVs recharged.
     * @return A string representation of the charger.
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append (getId() + ", ");
        builder.append (getChargingSpeed() + "kwh, ");
        builder.append (getChargingFee() + "€, ");
        builder.append (eVsRecharged.size() + ", ");
        builder.append (getAmountCollected() + "€");
        
        return builder.toString();
    }

    /**
     * Returns a complete string representation of the charger, including details of all {@link ElectricVehicle}s it has recharged.
     * @return A string containing complete information about the charger and its usage history.
     */
    public String getCompleteInfo()
    {
         StringBuilder builder = new StringBuilder();
        
        builder.append (toString());
        builder.append('\n');
        for(int i = 0; i < eVsRecharged.size(); i++){
            builder.append (eVsRecharged.get(i).getInitialFinalInfo()); 
            builder.append('\n');
        }
        
        return builder.toString();
    }
    
    /**
     * Adds an {@link ElectricVehicle} to the list of vehicles that have been recharged by this charger.
     * @param vehicle The electric vehicle that was recharged.
     */
    public void addEvRecharged(ElectricVehicle vehicle){
        eVsRecharged.add(vehicle);
    }
    
    /**
     * @return The total number of {@link ElectricVehicle}s that have been recharged by this charger.
     */
    public int getNumerEVRecharged(){
        return eVsRecharged.size();
    }
    
    public void refreshAmountCollected(float collected)
    {
        amountCollected += collected;
    }
    
    
    /**
     * Simulates the charging process for an {@link ElectricVehicle}.
     * Increases the amount collected and registers the vehicle as recharged.
     * @param vehicle The vehicle to recharge.
     * @param kwsRecharging The amount of kWh to be recharged.
     * @return The cost of the recharge operation.
     */
    public float recharge(ElectricVehicle vehicle,int kwsRecharging){
        float fee = 0;
        if(kwsRecharging > 0){
            fee = kwsRecharging * chargingFee;
            refreshAmountCollected(fee);
            addEvRecharged(vehicle);
            vehicle.setBatteryLevel(vehicle.getBatteryCapacity());      //the vehicle is recharged to its max capacity
        }
        return fee;
    }
}