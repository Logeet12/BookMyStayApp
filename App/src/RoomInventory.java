import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    private Map<String, Integer> availability = new HashMap<>();

    public void setAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    public int getAvailability(String roomType) {   // fixes error #4
        return availability.getOrDefault(roomType, 0);
    }

    public void decrementRoom(String roomType) {    // fixes error #5
        int count = getAvailability(roomType);
        if (count > 0) {
            availability.put(roomType, count - 1);
        }
    }
}