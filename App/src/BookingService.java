import java.util.*;

class BookingService {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private Map<String, Set<String>> roomTypeToIds = new HashMap<>();

    // Process queue (FIFO)
    public void processBookings(BookingRequestQueue queue, RoomInventory inventory) {

        while (true) {
            Reservation request = queue.getNextRequest();

            if (request == null) {
                System.out.println("\nAll requests processed.");
                break;
            }

            String roomType = request.getRoomType();

            System.out.println("\nProcessing request for " + request.getGuestName());

            // Check availability
            if (inventory.getAvailability(roomType) > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Ensure uniqueness (defensive check)
                if (allocatedRoomIds.contains(roomId)) {
                    System.out.println("Error: Duplicate Room ID detected!");
                    continue;
                }

                // Allocate
                allocatedRoomIds.add(roomId);

                roomTypeToIds.putIfAbsent(roomType, new HashSet<>());
                roomTypeToIds.get(roomType).add(roomId);

                // Update inventory immediately (atomic step)
                inventory.decrementRoom(roomType);

                // Confirm booking
                System.out.println("Booking CONFIRMED for " + request.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Assigned Room ID: " + roomId);

            } else {
                System.out.println("Booking FAILED for " + request.getGuestName() + " (No availability)");
            }
        }
    }

    // Simple unique ID generator
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Display allocated rooms
    public void displayAllocations() {
        System.out.println("\nFinal Room Allocations:");

        for (String type : roomTypeToIds.keySet()) {
            System.out.println(type + " Rooms: " + roomTypeToIds.get(type));
        }
    }
}