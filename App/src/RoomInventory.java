import java.util.HashMap;
import java.util.Stack;

class RoomInventory {

    private final HashMap<String, Integer> inventory = new HashMap<>();
    private final Stack<String> rollbackStack = new Stack<>();

    // Add room types with initial count
    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    // Check availability
    public boolean isAvailable(String type) {
        return inventory.getOrDefault(type, 0) > 0;
    }

    // Allocate room (during booking)
    public void allocateRoom(String type, String roomId) {
        if (!isAvailable(type)) {
            System.out.println("No rooms available for type: " + type);
            return;
        }

        inventory.put(type, inventory.get(type) - 1);
        rollbackStack.push(roomId);

        System.out.println("Room allocated: " + roomId);
    }

    // ✅ REQUIRED METHOD (Fix for your error)
    public void releaseRoom(String type, String roomId) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
        rollbackStack.push(roomId);

        System.out.println("Room released (rollback): " + roomId);
    }

    // Display inventory
    public void showInventory() {
        System.out.println("Current Inventory: " + inventory);
    }

    // Display rollback stack
    public void showRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}