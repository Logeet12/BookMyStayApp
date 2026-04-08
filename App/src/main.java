import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {

        // Create Inventory
        RoomInventory inventory = new RoomInventory();

        // Set availability
        inventory.setAvailability("Single", 5);
        inventory.setAvailability("Double", 0);
        inventory.setAvailability("Suite", 2);

        // Create Room Catalog (Domain objects)
        Map<String, Room> roomCatalog = new HashMap<>();
        roomCatalog.put("Single", new Room("Single", 2000, "WiFi, TV"));
        roomCatalog.put("Double", new Room("Double", 3500, "WiFi, TV, AC"));
        roomCatalog.put("Suite", new Room("Suite", 7000, "WiFi, TV, AC, Mini Bar"));

        // Search Service
        SearchService searchService = new SearchService();

        // Guest searches for rooms
        searchService.searchAvailableRooms(inventory, roomCatalog);
    }
}