public class main {

    public static void main(String[] args) {

        // Inventory
        RoomInventory inventory = new RoomInventory();
        inventory.setAvailability("Single", 2);
        inventory.setAvailability("Suite", 1);

        // Queue
        BookingRequestQueue queue = new BookingRequestQueue();
        queue.addRequest(new Reservation(null, "Alice", "Single"));
        queue.addRequest(new Reservation(null, "Bob", "Suite"));
        queue.addRequest(new Reservation(null, "Charlie", "Single"));

        // History + Service
        BookingHistory history = new BookingHistory();
        BookingService bookingService = new BookingService();

        // Process bookings
        bookingService.processBookings(queue, inventory, history);

        // Reporting
        BookingReportService reportService = new BookingReportService();

        reportService.displayAllBookings(history);
        reportService.generateSummaryReport(history);
        reportService.totalBookings(history);
    }
}