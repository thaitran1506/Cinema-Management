package cinema;

import java.util.Scanner;

public class Theater {
    private final int numRows;
    private final int numSeatsPerRow;
    private final Seat[][] seats;
    private int purchasedTickets;
    private int currentIncome;
    private final int totalIncome;

    public Theater(int numRows, int numSeatsPerRow) {
        this.numRows = numRows;
        this.numSeatsPerRow = numSeatsPerRow;
        this.seats = new Seat[numRows][numSeatsPerRow];
        this.totalIncome = calculateTotalPotentialIncome();

        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numSeatsPerRow; col++) {
                seats[row][col] = new Seat(row, col);
                seats[row][col].setPrice(getSeatPrice(row));
            }
        }
    }

    private int getSeatPrice(int rowIndex) {
        int totalSeats = numRows * numSeatsPerRow;
        if (totalSeats <= 60) {
            return 10;
        }
        return rowIndex < numRows / 2 ? 10 : 8;
    }

    private int calculateTotalPotentialIncome() {
        int income = 0;
        for (int row = 0; row < numRows; row++) {
            income += numSeatsPerRow * getSeatPrice(row);
        }
        return income;
    }

    public void showSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int col = 1; col <= numSeatsPerRow; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < numRows; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < numSeatsPerRow; col++) {
                System.out.print(seats[row][col].getStatusSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void buySeat(Scanner scanner) {
        while (true) {
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int col = scanner.nextInt();

            if (!isValidSeat(row, col)) {
                System.out.println("Wrong input!\n");
                continue;
            }

            Seat seat = seats[row - 1][col - 1];
            if (seat.isBooked()) {
                System.out.println("That ticket has already been purchased!\n");
                continue;
            }

            seat.book();
            purchasedTickets++;
            currentIncome += seat.getPrice();
            System.out.println("Ticket price: $" + seat.getPrice());
            System.out.println();
            break;
        }
    }

    private boolean isValidSeat(int row, int col) {
        return row >= 1 && row <= numRows && col >= 1 && col <= numSeatsPerRow;
    }

    public void printStatistics() {
        int totalSeats = numRows * numSeatsPerRow;
        double percent = (double) purchasedTickets / totalSeats * 100;

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", percent);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
        System.out.println();
    }

    public void showMenu() {
        System.out.print("""
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """);
    }
}
