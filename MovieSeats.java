import java.util.Scanner;

public class MovieSeats {
    private static final int ROWS = 4;
    private static final int SEATS_PER_ROW = 6;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean[][] seats = new boolean[ROWS][SEATS_PER_ROW];
        System.out.println("Reserve seats in a theater with 4 rows of 6 seats.");
        printSeats(seats);

        while (true) {
            int row = readInteger(console, "\nRow to reserve (0 to finish): ");
            if (row == 0) {
                break;
            }
            int seat = readInteger(console, "Seat number: ");
            reserveSeat(seats, row, seat);
            printSeats(seats);
        }
        System.out.println("Seats taken: " + countTaken(seats) + " of " + (ROWS * SEATS_PER_ROW));
    }

    public static int readInteger(Scanner console, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (console.hasNextInt()) {
                return console.nextInt();
            }
            System.out.println("Please enter a whole number.");
            console.next();
        }
    }

    // The user counts from 1, but Java array indexes start at 0.
    public static void reserveSeat(boolean[][] seats, int row, int seat) {
        if (row < 1 || row > seats.length || seat < 1 || seat > seats[row - 1].length) {
            System.out.println("There is no such seat.");
        } else if (seats[row - 1][seat - 1]) {
            System.out.println("That seat is already taken.");
        } else {
            seats[row - 1][seat - 1] = true;
            System.out.println("Reserved!");
        }
    }

    public static void printSeats(boolean[][] seats) {
        for (int row = 0; row < seats.length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int col = 0; col < seats[row].length; col++) {
                System.out.print((seats[row][col] ? "X" : "O") + " ");
            }
            System.out.println();
        }
    }

    public static int countTaken(boolean[][] seats) {
        int count = 0;
        for (boolean[] row : seats) {
            for (boolean taken : row) {
                if (taken) {
                    count++;
                }
            }
        }
        return count;
    }
}
