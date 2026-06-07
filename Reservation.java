package hotel;

public class Reservation {

    String customerName;
    int roomNumber;
    String roomType;
    int days;
    int amount;
    String bookingId;

    Reservation(String customerName,
                int roomNumber,
                String roomType,
                int days,
                int amount,
                String bookingId) {

        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.days = days;
        this.amount = amount;
        this.bookingId = bookingId;
    }
}