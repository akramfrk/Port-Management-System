public abstract class Vehicle {
    private String owner;
    private String brand;
    private String model;
    private String licensePlate;
    
    public Vehicle(String owner, String brand, String model, String licensePlate) {
        this.owner = owner;
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }
    
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    public abstract String getVehicleDetails();
    
    @Override
    public String toString() {
        return "Owner: " + owner + 
               ", Brand: " + brand + 
               ", Model: " + model + 
               ", License Plate: " + licensePlate;
    }
}
