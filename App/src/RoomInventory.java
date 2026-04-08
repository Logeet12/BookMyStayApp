import java.util.Map;
import java.util.HashMap;

public class RoomInventory {

    private Map<String, Integer> availability = new HashMap<>();

    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    public void decrementRoom(String roomType) {
        int count = getAvailability(roomType);
        if (count > 0) {
            availability.put(roomType, count - 1);
        }
    }
}