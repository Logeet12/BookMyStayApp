import java.util.ArrayList;
import java.util.List;

class BookingHistory {

    // List preserves insertion (confirmation) order
    private List<Reservation> confirmedBookings = new ArrayList<>();

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedBookings.add(reservation);
    }

    // Read-only access (defensive copy)
    public List<Reservation> getAllReservations() {
        return new ArrayList<>(confirmedBookings);
    }
}