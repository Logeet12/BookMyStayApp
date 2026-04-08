import java.util.LinkedList;
import java.util.Queue;

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("Booking request added for " + reservation.getGuestName());
    }

    // View next request (without removing)
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    // Remove next request (dequeue) - used later in allocation
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Display all queued requests
    public void displayQueue() {
        System.out.println("\nCurrent Booking Queue:");
        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : requestQueue) {
            r.display();
        }
    }
}