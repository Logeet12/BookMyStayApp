import java.io.Serializable;
import java.util.HashMap;

class SystemState implements Serializable {
    private static final long serialVersionUID = 1L;

    HashMap<String, Booking> bookings;
    HashMap<String, Integer> inventory;

    public SystemState(HashMap<String, Booking> bookings,
                       HashMap<String, Integer> inventory) {
        this.bookings = bookings;
        this.inventory = inventory;
    }
}