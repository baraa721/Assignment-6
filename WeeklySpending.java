import java.util.Scanner;

public class WeeklySpending {
    private static final String[] DAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double[] spending = readSpending(console);
        printReport(spending);
    }

    // Read one nonnegative amount for each day of the week.
    public static double[] readSpending(Scanner console) {
        double[] spending = new double[DAYS.length];
        System.out.println("How much did you spend on each day this week?");
        for (int i = 0; i < spending.length; i++) {
            spending[i] = readAmount(console, DAYS[i] + ": $");
        }
        return spending;
    }

    public static double readAmount(Scanner console, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!console.hasNextDouble()) {
                System.out.println("Please enter a valid number.");
                console.next();
            } else {
                double amount = console.nextDouble();
                if (!Double.isFinite(amount) || amount < 0) {
                    System.out.println("Amount must be zero or greater.");
                } else {
                    return amount;
                }
            }
        }
    }

    public static double totalSpending(double[] spending) {
        double total = 0;
        for (double amount : spending) {
            total += amount;
        }
        return total;
    }

    public static int highestDayIndex(double[] spending) {
        int highest = 0;
        for (int i = 1; i < spending.length; i++) {
            if (spending[i] > spending[highest]) {
                highest = i;
            }
        }
        return highest;
    }

    public static void printReport(double[] spending) {
        System.out.println("\nDay   Amount");
        System.out.println("------------");
        for (int i = 0; i < spending.length; i++) {
            System.out.printf("%-3s  $%.2f%n", DAYS[i], spending[i]);
        }
        double total = totalSpending(spending);
        int highest = highestDayIndex(spending);
        System.out.printf("%nTotal spent:   $%.2f%n", total);
        System.out.printf("Daily average: $%.2f%n", total / spending.length);
        System.out.printf("Highest day:   %s ($%.2f)%n", DAYS[highest], spending[highest]);
    }
}
