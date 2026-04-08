public class main {

    public static void main(String[] args) {

        // Create Booking Queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Simulate multiple guest requests (arrival order matters)
        Reservation r1 = new Reservation("Alice", "Single");
        Reservation r2 = new Reservation("Bob", "Suite");
        Reservation r3 = new Reservation("Charlie", "Single");

        // Add requests to queue (FIFO order maintained)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // Display queue
        bookingQueue.displayQueue();

        // Peek next request (no removal)
        System.out.println("\nNext request to process:");
        Reservation next = bookingQueue.peekNextRequest();
        if (next != null) {
            next.display();
        }
    }
}