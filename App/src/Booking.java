import java.io.Serializable;

class Booking implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookingId;
    private String roomType;
    private String roomId;
    private boolean isCancelled;

    public Booking(String bookingId, String roomType, String roomId) {
        this.bookingId = bookingId;
        this.roomType = roomType;
        this.roomId = roomId;
        this.isCancelled = false;
    }

    public String getBookingId() { return bookingId; }
    public String getRoomType() { return roomType; }
    public String getRoomId() { return roomId; }
    public boolean isCancelled() { return isCancelled; }

    public void cancel() { this.isCancelled = true; }
}