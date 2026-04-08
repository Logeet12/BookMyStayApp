import java.util.HashMap;

class RoomInventory {

    private final HashMap<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Deluxe", 1);
        inventory.put("Standard", 2);
    }

    // ✅ CORRECT METHOD (matches your usage)
    public synchronized boolean allocateRoom(String type) {
        int available = inventory.getOrDefault(type, 0);

        if (available > 0) {
            System.out.println(Thread.currentThread().getName()
                    + " allocating " + type);

            // simulate delay (to show concurrency effect)
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            inventory.put(type, available - 1);
            return true;
        }

        return false;
    }

    public synchronized void releaseRoom(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public void showInventory() {
        System.out.println("Final Inventory: " + inventory);
    }
}