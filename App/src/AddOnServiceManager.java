import java.util.*;

class AddOnServiceManager {

    // Map: Reservation ID → List of Services
    private Map<String, List<AddOnService>> reservationServices = new HashMap<>();

    // Add service to a reservation
    public void addService(String reservationId, AddOnService service) {
        reservationServices.putIfAbsent(reservationId, new ArrayList<>());
        reservationServices.get(reservationId).add(service);

        System.out.println(service.getName() + " added to Reservation " + reservationId);
    }

    // Get all services for a reservation
    public List<AddOnService> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    // Calculate total cost of add-ons
    public double calculateTotalCost(String reservationId) {
        double total = 0;

        List<AddOnService> services = getServices(reservationId);

        for (AddOnService s : services) {
            total += s.getCost();
        }

        return total;
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {
        List<AddOnService> services = getServices(reservationId);

        System.out.println("\nServices for Reservation " + reservationId + ":");

        if (services.isEmpty()) {
            System.out.println("No add-on services selected.");
            return;
        }

        for (AddOnService s : services) {
            s.display();
        }

        System.out.println("Total Add-On Cost: ₹" + calculateTotalCost(reservationId));
    }
}