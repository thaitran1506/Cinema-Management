package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get theater dimensions
        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int numSeatsPerRow = scanner.nextInt();
        System.out.println();

        Theater theater = new Theater(numRows, numSeatsPerRow);

        boolean running = true;

        while (running) {
            theater.showMenu();
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> theater.showSeats();
                case 2 -> theater.buySeat(scanner);
                case 3 -> theater.printStatistics();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }

        scanner.close();
    }
}
