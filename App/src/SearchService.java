import java.util.Map;

class SearchService {

    public void searchAvailableRooms(RoomInventory inventory, Map<String, Room> roomCatalog) {

        System.out.println("Available Rooms:\n");

        Map<String, Integer> availabilityMap = inventory.getAllAvailability();

        for (String roomType : availabilityMap.keySet()) {

            int count = availabilityMap.get(roomType);

            // Validation: Only show available rooms
            if (count > 0) {

                Room room = roomCatalog.get(roomType);

                // Defensive check
                if (room != null) {
                    room.displayDetails();
                    System.out.println("Available Count: " + count);
                    System.out.println("===========================");
                }
            }
        }
    }
}