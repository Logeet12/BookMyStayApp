import java.util.*;

class BookingService {

    private Set<String> allocatedRoomIds = new HashSet<>();

    public void processBookings(BookingRequestQueue queue,
                                RoomInventory inventory,
                                BookingHistory history) {

        while (true) {
            Reservation request = queue.getNextRequest();

            if (request == null) {
                break;
            }

            String roomType = request.getRoomType();

            if (inventory.getAvailability(roomType) > 0) {

                // Generate ID
                String roomId = generateRoomId(roomType);

                if (allocatedRoomIds.contains(roomId)) {
                    continue;
                }

                allocatedRoomIds.add(roomId);

                // Update inventory
                inventory.decrementRoom(roomType);

                // Create confirmed reservation
                Reservation confirmed = new Reservation(
                        roomId,
                        request.getGuestName(),
                        roomType
                );

                // Store in history
                history.addReservation(confirmed);

                System.out.println("CONFIRMED: " + confirmed.getReservationId());

            } else {
                System.out.println("FAILED: " + request.getGuestName());
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" +
                UUID.randomUUID().toString().substring(0, 5);
    }
}