package hotel;

public class Room {

    int roomNumber;
    String roomType;
    int price;
    boolean available;

    Room(int roomNumber, String roomType,
         int price, boolean available) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.available = available;
    }
}