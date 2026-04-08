import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> availability = new HashMap<>();

    // Add or update room availability
    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    // Read-only access
    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    // Expose read-only map (defensive)
    public Map<String, Integer> getAllAvailability() {
        return new HashMap<>(availability); // return copy to prevent modification
    }
}