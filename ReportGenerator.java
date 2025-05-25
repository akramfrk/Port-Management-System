import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportGenerator {
    
    public static String generateReport(Trip trip) throws IOException {
        String fileName = "Trip_" + trip.getTripId() + "_Report.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("=================================================\n");
            writer.write("            PORT OF ALGIERS - TRIP REPORT         \n");
            writer.write("=================================================\n\n");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            writer.write("Report generated: " + now.format(formatter) + "\n\n");
            
            writer.write("TRIP DETAILS\n");
            writer.write("-------------------------------------------------\n");
            writer.write("Trip ID: " + trip.getTripId() + "\n");
            writer.write("Date: " + trip.getFormattedDate() + "\n");
            writer.write("Destination: " + trip.getDestination() + "\n");
            writer.write("Total Vehicles: " + trip.getVehicleCount() + "\n\n");
            
            writer.write("VEHICLE INVENTORY\n");
            writer.write("-------------------------------------------------\n");
            
            int carCount = 0;
            int truckCount = 0;
            int truckWithTrailerCount = 0;
            
            for (Vehicle vehicle : trip.getVehicles()) {
                if (vehicle instanceof Car) {
                    carCount++;
                } else if (vehicle instanceof Truck) {
                    truckCount++;
                    if (((Truck) vehicle).hasTrailer()) {
                        truckWithTrailerCount++;
                    }
                }
            }
            
            writer.write("Cars: " + carCount + "\n");
            writer.write("Trucks: " + truckCount + " (with trailer: " + truckWithTrailerCount + ")\n\n");
            
            writer.write("DETAILED VEHICLE LIST\n");
            writer.write("-------------------------------------------------\n");
            
            int index = 1;
            for (Vehicle vehicle : trip.getVehicles()) {
                writer.write(index + ". " + vehicle.getVehicleDetails() + "\n");
                index++;
            }
            
            writer.write("\n=================================================\n");
            writer.write("                 END OF REPORT                   \n");
            writer.write("=================================================\n");
        }
        
        return fileName;
    }
}
