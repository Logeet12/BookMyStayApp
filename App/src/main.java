public class main {

    public static void main(String[] args) {

        // Assume this ID came from Use Case 6 (allocation)
        String reservationId = "SI-AB123";

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService wifi = new AddOnService("Premium WiFi", 300);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 1000);

        // Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Guest selects services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, wifi);
        manager.addService(reservationId, airportPickup);

        // Display selected services
        manager.displayServices(reservationId);
    }
}