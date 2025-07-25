package FinancialForecasting;

import java.util.Scanner;
class FinancialForecasting {

    // Recursive method to calculate future value
    static double futureValue(int year, double initial, double rate) {
        if (year == 0) {
            return initial;  // base case
        } else {
            return futureValue(year - 1, initial, rate) * (1 + rate);
        }
    }

    // Optimized version using memoization
    static double futureValueMemo(int year, double initial, double rate, double[] memo) {
        if (memo[year] != 0) return memo[year];
        if (year == 0) return memo[0] = initial;
        return memo[year] = futureValueMemo(year - 1, initial, rate, memo) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter initial amount: ");
        double initialAmount = scanner.nextDouble();

        System.out.print("Enter annual growth rate (in %): ");
        double growthRate = scanner.nextDouble() / 100; // Convert to decimal

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();

        // Recursive forecast
        System.out.println("\n=== Financial Forecast (Recursive) ===");
        for (int i = 0; i <= years; i++) {
            double fv = futureValue(i, initialAmount, growthRate);
            System.out.printf("Year %2d: %.2f%n", i, fv);
        }

        // Memoized forecast
        System.out.println("\n=== Financial Forecast (Memoized) ===");
        double[] memo = new double[years + 1];
        for (int i = 0; i <= years; i++) {
            double fvMemo = futureValueMemo(i, initialAmount, growthRate, memo);
            System.out.printf("Year %2d: %.2f%n", i, fvMemo);
        }

        scanner.close();
    }
}
