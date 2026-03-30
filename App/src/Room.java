public abstract class Room {

    // Number of beds available in the room
    protected int numberOfBeds;

    // Total size of the room in square feet
    protected int squareFeet;

    // Price charged per night
    protected double pricePerNight;

    // Constructor
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    // Display room details
    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sq.ft");
        System.out.println("Price per night: ₹" + pricePerNight);
        System.out.println("-----------------------------");
    }
}