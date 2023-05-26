package DefiningClasses_Exercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTravelled;

    public Car (String model,double fuelAmount,double fuelCostFor1km){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTravelled = 0;
    }
    public double calculateFuelExpense(int amountOfKm){
        return this.fuelCostFor1km * amountOfKm;
    }
    public boolean hasEnoughFuel (int amountOfKm){
        return this.fuelAmount >= calculateFuelExpense(amountOfKm);
    }
    public void drive(int amountOfKm){

      if (hasEnoughFuel(amountOfKm)){
         this.fuelAmount -= calculateFuelExpense(amountOfKm);
         this.distanceTravelled += amountOfKm;
      }else{
          System.out.println("Insufficient fuel for the drive");
      }
    }


    public String getModel(){
        return this.model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostFor1km() {
        return fuelCostFor1km;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTravelled);
    }
}
