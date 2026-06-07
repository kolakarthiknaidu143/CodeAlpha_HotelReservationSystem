package hotel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HotelService {

    Scanner sc = new Scanner(System.in);

    Room[] rooms = {

            new Room(101,
                    "Standard",
                    1000,
                    true),

            new Room(102,
                    "Deluxe",
                    2000,
                    true),

            new Room(103,
                    "Suite",
                    3500,
                    true)
    };

    Reservation booking = null;

    // ---------------- VIEW ROOMS ----------------
    void viewRooms() {

        System.out.println(
                "\n===== AVAILABLE ROOMS =====");

        for (Room room : rooms) {

            System.out.println(
                    room.roomNumber
                            + " - "
                            + room.roomType
                            + " - ₹"
                            + room.price
                            + " - "
                            + (room.available
                            ? "Available"
                            : "Booked")
            );
        }
    }

    // ---------------- BOOK ROOM ----------------
    void bookRoom() {

        System.out.print(
                "\nEnter Customer Name: ");

        String name =
                sc.nextLine();

        // Validation
        if (name.isEmpty()) {

            System.out.println(
                    "Name cannot be empty!");
            return;
        }

        System.out.print(
                "Enter Room Number: ");

        int roomNo =
                sc.nextInt();

        System.out.print(
                "Enter Number of Days: ");

        int days =
                sc.nextInt();

        sc.nextLine();

        // Validation
        if (days <= 0) {

            System.out.println(
                    "Days must be greater than 0!");
            return;
        }

        boolean found =
                false;

        for (Room room : rooms) {

            if (room.roomNumber
                    == roomNo) {

                found = true;

                if (room.available) {

                    room.available =
                            false;

                    int total =
                            room.price
                                    * days;

                    String bookingId =
                            "B"
                                    + (int)
                                    (Math.random()
                                            * 1000);

                    booking =
                            new Reservation(
                                    name,
                                    roomNo,
                                    room.roomType,
                                    days,
                                    total,
                                    bookingId
                            );

                    // Save to File
                    saveBookingToFile();

                    System.out.println(
                            "\nBooking Successful!");

                    System.out.println(
                            "Booking ID: "
                                    + bookingId);

                    return;

                } else {

                    System.out.println(
                            "Room Already Booked!");

                    return;
                }
            }
        }

        if (!found) {

            System.out.println(
                    "Invalid Room Number!");
        }
    }

    // ---------------- SAVE FILE ----------------
    void saveBookingToFile() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "booking.txt",
                            true
                    );

            writer.write(
                    booking.customerName
                            + ", "
                            + booking.roomNumber
                            + ", "
                            + booking.roomType
                            + ", "
                            + booking.days
                            + ", ₹"
                            + booking.amount
                            + ", "
                            + booking.bookingId
                            + "\n"
            );

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving booking!");
        }
    }

    // ---------------- VIEW BOOKING ----------------
    void viewBooking() {

        if (booking == null) {

            System.out.println(
                    "\nNo Booking Found!");

        } else {

            System.out.println(
                    "\n===== BOOKING DETAILS =====");

            System.out.println(
                    "Booking ID: "
                            + booking.bookingId);

            System.out.println(
                    "Customer Name: "
                            + booking.customerName);

            System.out.println(
                    "Room Type: "
                            + booking.roomType);

            System.out.println(
                    "Days: "
                            + booking.days);

            System.out.println(
                    "Amount: ₹"
                            + booking.amount);
        }
    }

    // ---------------- CANCEL BOOKING ----------------
    void cancelBooking() {

        if (booking == null) {

            System.out.println(
                    "\nNo Booking Found!");

            return;
        }

        System.out.print(
                "\nEnter Booking ID: ");

        String id =
                sc.nextLine();

        if (id.equals(
                booking.bookingId)) {

            for (Room room
                    : rooms) {

                if (room.roomNumber
                        == booking.roomNumber) {

                    room.available =
                            true;
                }
            }

            booking = null;

            System.out.println(
                    "Booking Cancelled Successfully!");

        } else {

            System.out.println(
                    "Invalid Booking ID!");
        }
    }

    // ---------------- PAYMENT ----------------
    void payment() {

        if (booking == null) {

            System.out.println(
                    "\nNo Booking Found!");

        } else {

            System.out.println(
                    "\nPayment Successful!");

            System.out.println(
                    "Amount Paid: ₹"
                            + booking.amount);
        }
    }
}