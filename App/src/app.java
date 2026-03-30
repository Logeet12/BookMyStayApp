public class app {

    public static void main(String[] args) {

        // Step 1: Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Step 2: Register room types
        inventory.addRoomType("SingleRoom", 10);
        inventory.addRoomType("DoubleRoom", 5);
        inventory.addRoomType("SuiteRoom", 2);

        // Step 3: Display initial inventory
        inventory.displayInventory();

        // Step 4: Check availability
        System.out.println("Available Single Rooms: " +
                inventory.getAvailability("SingleRoom"));

        // Step 5: Update availability (booking)
        System.out.println("\nBooking 2 Single Rooms...");
        inventory.updateAvailability("SingleRoom", -2);

        // Step 6: Update availability (cancellation)
        System.out.println("Cancelling 1 Suite Room...");
        inventory.updateAvailability("SuiteRoom", +1);

        // Step 7: Display updated inventory
        inventory.displayInventory();
    }
}