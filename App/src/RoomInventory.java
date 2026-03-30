import java.util.HashMap;
import java.util.Map;

public class RoomInventory {

    // Centralized storage for room availability
    private HashMap<String, Integer> inventory;

    // Constructor → initialize inventory
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register room type with count
    public void addRoomType(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability of a specific room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability (increase or decrease)
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        int updated = current + change;

        if (updated < 0) {
            System.out.println("Not enough rooms available for: " + roomType);
            return;
        }

        inventory.put(roomType, updated);
    }

    // Display full inventory
    public void displayInventory() {
        System.out.println("---- Room Inventory ----");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("------------------------");
    }
}