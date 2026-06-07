package hotel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        HotelService hotel =
                new HotelService();

        int choice;

        do {

            System.out.println(
                    "\n===== HOTEL RESERVATION SYSTEM =====");

            System.out.println(
                    "1. View Rooms");

            System.out.println(
                    "2. Book Room");

            System.out.println(
                    "3. View Booking");

            System.out.println(
                    "4. Cancel Booking");

            System.out.println(
                    "5. Payment");

            System.out.println(
                    "6. Exit");

            System.out.print(
                    "Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    hotel.viewRooms();
                    break;

                case 2:
                    hotel.bookRoom();
                    break;

                case 3:
                    hotel.viewBooking();
                    break;

                case 4:
                    hotel.cancelBooking();
                    break;

                case 5:
                    hotel.payment();
                    break;

                case 6:
                    System.out.println(
                            "Thank You!");
                    break;

                default:
                    System.out.println(
                            "Invalid Choice!");
            }

        } while (choice != 6);
    }
}