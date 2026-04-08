import java.util.HashMap;

class BookingManager {
    private HashMap<String, Booking> bookings = new HashMap<>();
    private RoomInventory inventory;

    public BookingManager(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public void cancelBooking(String bookingId) {
        System.out.println("\nProcessing cancellation for: " + bookingId);

        // Validation
        if (!bookings.containsKey(bookingId)) {
            System.out.println("Error: Booking does not exist.");
            return;
        }

        Booking booking = bookings.get(bookingId);

        if (booking.isCancelled()) {
            System.out.println("Error: Booking already cancelled.");
            return;
        }

        // Rollback logic
        String roomType = booking.getRoomType();
        String roomId = booking.getRoomId();

        // Step 1: Mark cancelled
        booking.cancel();

        // Step 2: Restore inventory
        inventory.releaseRoom(roomType, roomId);

        // Step 3: Update history (implicitly done via booking state)

        System.out.println("Cancellation successful for Booking ID: " + bookingId);
    }
}