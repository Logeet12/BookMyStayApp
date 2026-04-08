public class main {
    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Deluxe", 2);
        inventory.addRoomType("Standard", 3);

        BookingManager manager = new BookingManager(inventory);

        // Create bookings
        Booking b1 = new Booking("B101", "Deluxe", "D1");
        Booking b2 = new Booking("B102", "Standard", "S1");

        manager.addBooking(b1);
        manager.addBooking(b2);

        // Simulate allocations
        inventory.allocateRoom("Deluxe", "D1");
        inventory.allocateRoom("Standard", "S1");

        inventory.showInventory();

        // Cancel booking
        manager.cancelBooking("B101");

        inventory.showInventory();
        inventory.showRollbackStack();

        // Try invalid cancellation
        manager.cancelBooking("B101"); // already cancelled
        manager.cancelBooking("B999"); // non-existent
    }
}