import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PortManagementSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===================================================");
        System.out.println("  PORT OF ALGIERS - VEHICLE MANAGEMENT SYSTEM");
        System.out.println("===================================================");
        
        Trip currentTrip = createTrip(scanner);
        
        boolean addMoreVehicles = true;
        
        while (addMoreVehicles) {
            addVehicleToTrip(scanner, currentTrip);
            
            System.out.print("\nDo you want to add another vehicle? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            addMoreVehicles = response.equals("y") || response.equals("yes");
        }
        
        System.out.println("\n" + currentTrip.getTripSummary());
        
        try {
            String reportFile = ReportGenerator.generateReport(currentTrip);
            System.out.println("\nDetailed report has been saved to: " + reportFile);
        } catch (IOException e) {
            System.out.println("\nError generating report: " + e.getMessage());
        }
        
        System.out.println("\nThank you for using the Port of Algiers Vehicle Management System!");
        scanner.close();
    }
    
    private static Trip createTrip(Scanner scanner) {
        System.out.println("\nCREATE NEW TRIP");
        System.out.println("------------------");
        
        System.out.print("Enter Trip ID: ");
        String tripId = scanner.nextLine().trim();
        
        System.out.print("Enter Trip Date (dd/mm/yyyy): ");
        String dateString = scanner.nextLine().trim();
        
        String[] dateParts = dateString.split("/");
        LocalDate tripDate = LocalDate.of(
            Integer.parseInt(dateParts[2]),
            Integer.parseInt(dateParts[1]),
            Integer.parseInt(dateParts[0])
        );
        
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine().trim();
        
        return new Trip(tripId, tripDate, destination);
    }
    
    private static void addVehicleToTrip(Scanner scanner, Trip trip) {
        System.out.println("\nADD VEHICLE");
        System.out.println("------------------");
        
        System.out.print("Vehicle Type (1 for Car, 2 for Truck): ");
        int vehicleType = Integer.parseInt(scanner.nextLine().trim());
        
        System.out.print("Owner Name: ");
        String owner = scanner.nextLine().trim();
        
        System.out.print("Brand: ");
        String brand = scanner.nextLine().trim();
        
        System.out.print("Model: ");
        String model = scanner.nextLine().trim();
        
        System.out.print("License Plate: ");
        String licensePlate = scanner.nextLine().trim();
        
        if (vehicleType == 1) {
            System.out.print("Maximum Speed (km/h): ");
            int maxSpeed = Integer.parseInt(scanner.nextLine().trim());
            
            Car car = new Car(owner, brand, model, licensePlate, maxSpeed);
            trip.addVehicle(car);
            
            System.out.println("\nCar added successfully!");
            
        } else if (vehicleType == 2) {
            System.out.print("Has Trailer? (y/n): ");
            String hasTrailerInput = scanner.nextLine().trim().toLowerCase();
            boolean hasTrailer = hasTrailerInput.equals("y") || hasTrailerInput.equals("yes");
            
            Truck truck = new Truck(owner, brand, model, licensePlate, hasTrailer);
            trip.addVehicle(truck);
            
            System.out.println("\nTruck added successfully!");
            
        } else {
            System.out.println("\nInvalid vehicle type selected!");
        }
    }
}
