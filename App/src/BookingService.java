import java.util.*;

class BookingService {

    private final Set<String> allocatedRoomIds = new HashSet<>();
    private BookingValidator validator;

    public BookingService(BookingValidator validator) {
        this.validator = validator;
    }

    public void processBookings(BookingRequestQueue queue,
                                RoomInventory inventory,
                                BookingHistory history) {

        while (true) {
            Reservation request = queue.getNextRequest();

            if (request == null) {
                System.out.println("\nAll requests processed.");
                break;
            }

            try {
                // ✅ FAIL-FAST VALIDATION
                validator.validate(request, inventory);

                String roomType = request.getRoomType();

                // Generate unique ID
                String roomId = generateRoomId(roomType);

                if (allocatedRoomIds.contains(roomId)) {
                    throw new InvalidBookingException("Duplicate Room ID generated");
                }

                allocatedRoomIds.add(roomId);

                // Safe inventory update
                inventory.decrementRoom(roomType);

                // Create confirmed reservation
                Reservation confirmed = new Reservation(
                        roomId,
                        request.getGuestName(),
                        roomType
                );

                history.addReservation(confirmed);

                System.out.println("✅ CONFIRMED: " + roomId + " for " + request.getGuestName());

            } catch (InvalidBookingException e) {
                // ✅ GRACEFUL FAILURE
                System.out.println("❌ BOOKING FAILED: " + e.getMessage());
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" +
                UUID.randomUUID().toString().substring(0, 5);
    }
}