import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookingReportService {

    // Display all bookings
    public void displayAllBookings(BookingHistory history) {
        List<Reservation> reservations = history.getAllReservations();

        System.out.println("\n=== Booking History ===");

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Reservation r : reservations) {
            r.display();
        }
    }

    // Generate summary report (count by room type)
    public void generateSummaryReport(BookingHistory history) {
        List<Reservation> reservations = history.getAllReservations();

        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : reservations) {
            String type = r.getRoomType();
            roomTypeCount.put(type, roomTypeCount.getOrDefault(type, 0) + 1);
        }

        System.out.println("\n=== Booking Summary Report ===");

        for (String type : roomTypeCount.keySet()) {
            System.out.println(type + " Rooms Booked: " + roomTypeCount.get(type));
        }
    }

    // Total bookings count
    public void totalBookings(BookingHistory history) {
        int count = history.getAllReservations().size();
        System.out.println("\nTotal Confirmed Bookings: " + count);
    }
}