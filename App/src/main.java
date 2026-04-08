import java.util.*;

public class main {

    public static void main(String[] args) {

        // Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.setAvailability("Single", 1);
        inventory.setAvailability("Suite", 1);

        // Valid room types
        Set<String> validTypes = new HashSet<>();
        validTypes.add("Single");
        validTypes.add("Suite");

        // Validator
        BookingValidator validator = new BookingValidator(validTypes);

        // Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Test cases
        queue.addRequest(new Reservation(null, "Alice", "Single")); // valid
        queue.addRequest(new Reservation(null, "", "Suite"));       // invalid name
        queue.addRequest(new Reservation(null, "Bob", "Deluxe"));   // invalid type
        queue.addRequest(new Reservation(null, "Charlie", "Single")); // no availability

        // History
        BookingHistory history = new BookingHistory();

        // Service
        BookingService service = new BookingService(validator);

        service.processBookings(queue, inventory, history);
    }
}