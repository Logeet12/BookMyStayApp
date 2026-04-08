import java.util.Set;

class BookingValidator {

    private Set<String> validRoomTypes;

    public BookingValidator(Set<String> validRoomTypes) {
        this.validRoomTypes = validRoomTypes;
    }

    // Validate booking request
    public void validate(Reservation request, RoomInventory inventory) throws InvalidBookingException {

        // Null check
        if (request == null) {
            throw new InvalidBookingException("Reservation request cannot be null");
        }

        // Guest name validation
        if (request.getGuestName() == null || request.getGuestName().trim().isEmpty()) {
            throw new InvalidBookingException("Guest name is required");
        }

        // Room type validation
        String roomType = request.getRoomType();

        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException("Room type is required");
        }

        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }

        // Inventory validation
        int available = inventory.getAvailability(roomType);

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }
    }
}