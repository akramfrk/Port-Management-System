public class Truck extends Vehicle {
    private boolean hasTrailer;
    
    public Truck(String owner, String brand, String model, String licensePlate, boolean hasTrailer) {
        super(owner, brand, model, licensePlate);
        this.hasTrailer = hasTrailer;
    }
    
    public boolean hasTrailer() {
        return hasTrailer;
    }
    
    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }
    
    @Override
    public String getVehicleDetails() {
        return "Truck: " + super.toString() + 
               ", " + (hasTrailer ? "Has trailer" : "No trailer");
    }
}
