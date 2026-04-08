import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    // Decrement after allocation (controlled mutation)
    public void decrementRoom(String roomType) {
        int count = getAvailability(roomType);
        if (count > 0) {
            availability.put(roomType, count - 1);
        }
    }
}