import java.util.HashMap;

class RoomInventory {

    private final HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Deluxe", 1);   // small number to show conflict
        inventory.put("Standard", 2);
    }

    // 🔐 Critical Section
    public synchronized boolean allocateRoom(String roomType) {

        int available = inventory.getOrDefault(roomType, 0);

        if (available > 0) {
            System.out.println(Thread.currentThread().getName()
                    + " allocating " + roomType);

            // simulate delay (race condition scenario)
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            inventory.put(roomType, available - 1);
            return true;
        }

        return false;
    }

    public void showInventory() {
        System.out.println("Final Inventory: " + inventory);
    }
}