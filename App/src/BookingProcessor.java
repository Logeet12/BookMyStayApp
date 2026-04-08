class BookingProcessor extends Thread {

    private BookingQueue queue;
    private RoomInventory inventory;

    public BookingProcessor(String name, BookingQueue queue, RoomInventory inventory) {
        super(name);
        this.queue = queue;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        while (true) {
            BookingRequest request = queue.getRequest();

            boolean success = inventory.allocateRoom(request.getRoomType());

            if (success) {
                System.out.println(getName() + " SUCCESS for " + request.getGuestName());
            } else {
                System.out.println(getName() + " FAILED for " + request.getGuestName());
            }
        }
    }
}