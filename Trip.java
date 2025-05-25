import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trip {
    private String tripId;
    private LocalDate tripDate;
    private String destination;
    private List<Vehicle> vehicles;
    
    public Trip(String tripId, LocalDate tripDate, String destination) {
        this.tripId = tripId;
        this.tripDate = tripDate;
        this.destination = destination;
        this.vehicles = new ArrayList<>();
    }
    
    public String getTripId() {
        return tripId;
    }
    
    public LocalDate getTripDate() {
        return tripDate;
    }
    
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return tripDate.format(formatter);
    }
    
    public String getDestination() {
        return destination;
    }
    
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }
    
    public int getVehicleCount() {
        return vehicles.size();
    }
    
    public String getTripSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Trip ID: ").append(tripId).append("\n");
        summary.append("Date: ").append(getFormattedDate()).append("\n");
        summary.append("Destination: ").append(destination).append("\n");
        summary.append("Number of Vehicles: ").append(vehicles.size()).append("\n\n");
        
        summary.append("Vehicles List:\n");
        summary.append("==============\n");
        
        for (int i = 0; i < vehicles.size(); i++) {
            summary.append(i + 1).append(". ")
                   .append(vehicles.get(i).getVehicleDetails())
                   .append("\n");
        }
        
        return summary.toString();
    }
}
