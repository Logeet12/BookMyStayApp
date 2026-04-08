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

    public HashMap<String, Booking> getBookings() {
        return bookings;
    }

    public void setBookings(HashMap<String, Booking> bookings) {
        this.bookings = bookings;
    }
}