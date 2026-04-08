public class main {

    public static void main(String[] args) {

        // Inventory setup
        RoomInventory inventory = new RoomInventory();
        inventory.setAvailability("Single", 2);
        inventory.setAvailability("Suite", 1);

        // Queue setup
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Alice", "Single"));
        queue.addRequest(new Reservation("Bob", "Suite"));
        queue.addRequest(new Reservation("Charlie", "Single"));
        queue.addRequest(new Reservation("David", "Single")); // Should fail

        // Booking service
        BookingService service = new BookingService();

        // Process all bookings
        service.processBookings(queue, inventory);

        // Display results
        service.displayAllocations();
    }
}