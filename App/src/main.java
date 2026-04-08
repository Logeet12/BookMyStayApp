public class main {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingQueue queue = new BookingQueue();

        // Create multiple threads (processors)
        BookingProcessor t1 = new BookingProcessor("Thread-1", queue, inventory);
        BookingProcessor t2 = new BookingProcessor("Thread-2", queue, inventory);

        t1.start();
        t2.start();

        // Simulate multiple guests booking simultaneously
        queue.addRequest(new BookingRequest("Guest A", "Deluxe"));
        queue.addRequest(new BookingRequest("Guest B", "Deluxe"));
        queue.addRequest(new BookingRequest("Guest C", "Standard"));
        queue.addRequest(new BookingRequest("Guest D", "Standard"));
    }
}