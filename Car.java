public class Car extends Vehicle {
    private int maxSpeed;
    
    public Car(String owner, String brand, String model, String licensePlate, int maxSpeed) {
        super(owner, brand, model, licensePlate);
        this.maxSpeed = maxSpeed;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    @Override
    public String getVehicleDetails() {
        return "Car: " + super.toString() + ", Maximum Speed: " + maxSpeed + " km/h";
    }
}
